package com.taller.patrones.domain;

import java.util.Random;

public class MyRandom {

    private static final MyRandom instance = new MyRandom();
    private Random random;

    private MyRandom() {
        random = new Random();
    }

    public static MyRandom getInstance() {
        return instance;
    }

    public double nextDouble() {
        return random.nextDouble();
    }
}
