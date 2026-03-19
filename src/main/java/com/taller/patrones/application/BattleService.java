package com.taller.patrones.application;

import com.taller.patrones.application.observers.EstadisticasObserver;
import com.taller.patrones.application.observers.LastDamageObserver;
import com.taller.patrones.application.observers.LogObserver;
import com.taller.patrones.application.observers.SistemaDeAnalyticsObserver;
import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;
import com.taller.patrones.infrastructure.combat.CombatEngine;
import com.taller.patrones.infrastructure.persistence.BattleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Caso de uso: gestionar batallas.
 * <p>
 * Nota: Crea sus propias dependencias con new. Cada vez que necesitamos
 * un CombatEngine o BattleRepository, hacemos new aquí.
 */
public class BattleService {

    private final CombatEngine combatEngine = new CombatEngine();
    private final BattleRepository battleRepository = BattleRepository.getInstance();
    private List<DamageObserver> damageObservers = new ArrayList<>();

    public static final List<String> PLAYER_ATTACKS = List.of("TACKLE", "SLASH", "FIREBALL", "ICE_BEAM", "POISON_STING", "THUNDER", "METEOR");
    public static final List<String> ENEMY_ATTACKS = List.of("TACKLE", "SLASH", "FIREBALL");

    public BattleStartResult startBattle(String playerName, String enemyName) {
        Character player = new Character(
                playerName != null ? playerName : "Héroe",
                150, 25, 15, 15
        );

        Character enemy = new Character(
                enemyName != null ? enemyName : "Dragón",
                120, 30, 10, 15
        );

        addObserversToList();
        Battle battle = new Battle(player, enemy);
        String battleId = UUID.randomUUID().toString();
        battleRepository.save(battleId, battle);

        return new BattleStartResult(battleId, battle);
    }

    public Battle getBattle(String battleId) {
        return battleRepository.findById(battleId);
    }

    public void executePlayerAttack(String battleId, String attackName) {
        Battle battle = battleRepository.findById(battleId);
        if (battle == null || battle.isFinished() || !battle.isPlayerTurn()) return;

        Attack attack = combatEngine.createAttack(attackName);
        int damage = combatEngine.calculateDamage(battle.getPlayer(), battle.getEnemy(), attack);
        applyDamage(battle, battle.getPlayer(), battle.getEnemy(), damage, attack);
    }

    public void executeEnemyAttack(String battleId, String attackName) {
        Battle battle = battleRepository.findById(battleId);
        if (battle == null || battle.isFinished() || battle.isPlayerTurn()) return;

        Attack attack = combatEngine.createAttack(attackName != null ? attackName : "TACKLE");
        int damage = combatEngine.calculateDamage(battle.getEnemy(), battle.getPlayer(), attack);
        applyDamage(battle, battle.getEnemy(), battle.getPlayer(), damage, attack);
    }

    private void applyDamage(Battle battle, Character attacker, Character defender, int damage, Attack attack) {
        defender.takeDamage(damage);
        ParametrosAObservers parametrosAObservers = new ParametrosAObservers(damage, battle, attacker, defender, attack);
        notifyDamageObservers(parametrosAObservers);
        battle.switchTurn();
        if (!defender.isAlive()) {
            battle.finish(attacker.getName());
        }
    }

    public BattleStartResult startBattleFromExternal(String fighter1Name, int fighter1Hp, int fighter1Atk,
                                                     String fighter2Name, int fighter2Hp, int fighter2Atk) {
        Character player = new Character(fighter1Name, fighter1Hp, fighter1Atk, 10, 10);
        Character enemy = new Character(fighter2Name, fighter2Hp, fighter2Atk, 10, 10);
        Battle battle = new Battle(player, enemy);
        addObserversToList();
        String battleId = UUID.randomUUID().toString();
        battleRepository.save(battleId, battle);
        return new BattleStartResult(battleId, battle);
    }

    public record BattleStartResult(String battleId, Battle battle) {}

    public void addDamageObserver(DamageObserver damageObserver) {
        damageObservers.add(damageObserver);
    }
    public void removeDamageObserver(DamageObserver damageObserver) {
        damageObservers.remove(damageObserver);
    }
    private void notifyDamageObservers(ParametrosAObservers params) {
        for (DamageObserver damageObserver : damageObservers) {
            damageObserver.update(params);
        }
    }
    public void addObserversToList() {
        addDamageObserver(new SistemaDeAnalyticsObserver());
        addDamageObserver(new EstadisticasObserver());
        addDamageObserver(new LogObserver());
        addDamageObserver(new LastDamageObserver());
    }
}
