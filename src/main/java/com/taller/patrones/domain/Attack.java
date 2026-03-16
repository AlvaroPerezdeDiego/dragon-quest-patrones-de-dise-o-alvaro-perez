package com.taller.patrones.domain;

import lombok.Getter;

/**
 * Representa un ataque que puede ejecutar un personaje.
 */
@Getter
public abstract class Attack {

    private final String name;
    private final int basePower;
    private AttackTypeStrategy strategy;

    public Attack(String name, int basePower) {
        this.name = name;
        this.basePower = basePower;
    }

    public void setStrategy(AttackTypeStrategy  strategy) { this.strategy = strategy;}

    public abstract int execute(Character attacker, Character defender);
}
