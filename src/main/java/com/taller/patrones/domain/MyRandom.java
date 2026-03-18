package com.taller.patrones.domain;

import java.util.Random;

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
