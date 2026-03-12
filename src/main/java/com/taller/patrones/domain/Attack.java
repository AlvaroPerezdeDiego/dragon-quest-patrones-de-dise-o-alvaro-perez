package com.taller.patrones.domain;

/**
 * Representa un ataque que puede ejecutar un personaje.
 */
public class Attack {

    private final String name;
    private final int basePower;
    private final AttackType type;
    private AttackTypeStrategy strategy;

    public Attack(String name, int basePower, AttackType type) {
        this.name = name;
        this.basePower = basePower;
        this.type = type;
    }

    public String getName() { return name; }
    public int getBasePower() { return basePower; }
    public AttackType getType() { return type; }
    public AttackTypeStrategy getStrategy() { return strategy; }

    public void setStrategy(AttackTypeStrategy  strategy) { this.strategy = strategy;}

    /*
    public int calculateDamage(Character attacker, Character defender) {
        int raw = attacker.getAttack() * getBasePower() / 100;
        return Math.max(1, raw - defender.getDefense());
    }
    public int calculateDamageSpecial(Character attacker, Character defender) {
        int raw = attacker.getAttack() * getBasePower() / 100;
        int effectiveDef = defender.getDefense() / 2;
        return Math.max(1, raw - effectiveDef);
    }
    public int calculateDamageStatus(Character attacker) {
        return attacker.getAttack();
    }
*/
    public enum AttackType {
        NORMAL, SPECIAL, STATUS
    }
}
