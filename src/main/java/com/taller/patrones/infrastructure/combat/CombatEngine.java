package com.taller.patrones.infrastructure.combat;

import com.taller.patrones.domain.AttackCommand;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.attacks.*;

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
    public AttackCommand createAttack(String name) {
        String n = name != null ? name.toUpperCase() : "";
        return switch (n) {
            case "TACKLE" -> new Tackle();
            case "SLASH" -> new Slash();
            case "FIREBALL" -> new Fireball();
            case "ICE_BEAM" -> new IceBeam();
            case "POISON_STING" -> new PoisonSting();
            case "THUNDER" -> new Thunder();
            default -> new Golpe();
        };
    }

    /**
     * Calcula el daño según el tipo de ataque.
     * Cada fórmula nueva (ej. crítico, veneno con tiempo) requiere modificar este switch.
     */
    public int calculateDamage(Character attacker, Character defender, AttackCommand attack) {
        return attack.execute(defender, attacker);
    }
}
