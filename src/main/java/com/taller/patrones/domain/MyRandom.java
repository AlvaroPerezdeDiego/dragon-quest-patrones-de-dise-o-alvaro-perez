package com.taller.patrones.domain;

import java.util.Random;

/**
 * El enunciado se refería a un nuevo tipo de ataque, no a modificar los ataques que había, pero te lo has currado
 * <p>
 * https://github.com/AnaGciaSchz/dragon-quest-patrones/blob/solucion-ana/src/main/java/com/taller/patrones/domain/model/AttackType.java
 * <p>
 * https://github.com/AnaGciaSchz/dragon-quest-patrones/blob/solucion-ana/src/main/java/com/taller/patrones/domain/damageStrategy/CriticalDamageStrategy.java
 */
public class MyRandom {

    private static MyRandom instance;
    private Random random;

    private MyRandom() {
        random = new Random();
    }

    public static MyRandom getInstance() {
        if (instance == null) {
            instance = new MyRandom();
        }
        return instance;
    }

    public double nextDouble() {
        return random.nextDouble();
    }
}
