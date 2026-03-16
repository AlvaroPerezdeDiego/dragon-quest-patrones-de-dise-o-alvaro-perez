package com.taller.patrones.infrastructure.combat;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackFactory;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.attacks.*;
import com.taller.patrones.domain.concreteCreators.*;

import java.util.List;

import static com.taller.patrones.domain.AttackFactory.getConcreteCreator;

/**
 * Motor de combate. Calcula daño y crea ataques.
 * <p>
 * Nota: Esta clase crece cada vez que añadimos un ataque nuevo o un tipo de daño distinto.
 */
public class CombatEngine {
    /**
     * Crea un ataque a partir de su nombre.
     * Cada ataque nuevo requiere modificar este método.
     */

    public Attack createAttack(String name) {
        return AttackFactory.getConcreteCreator(name).getAttack();
    }

    /**
     * Calcula el daño según el tipo de ataque.
     * Cada fórmula nueva (ej. crítico, veneno con tiempo) requiere modificar este switch.
     */
    public int calculateDamage(Character attacker, Character defender, Attack attack) {
        return attack.execute(defender, attacker);
    }
}
