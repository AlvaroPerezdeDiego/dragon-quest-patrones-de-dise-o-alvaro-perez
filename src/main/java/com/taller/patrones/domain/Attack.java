package com.taller.patrones.domain;


/**
 * Representa un ataque que puede ejecutar un personaje.
 */
public abstract class Attack {

    private final String name;
    private final int basePower;
    private AttackTypeStrategy strategy;

    public Attack(String name, int basePower) {
        this.name = name;
        this.basePower = basePower;
    }

    public String getName() {return name;}
    public int getBasePower() {return basePower;}
    public AttackTypeStrategy getStrategy() {return strategy;}

    public void setStrategy(AttackTypeStrategy  strategy) { this.strategy = strategy;}

    public abstract int execute(Character attacker, Character defender);
}
