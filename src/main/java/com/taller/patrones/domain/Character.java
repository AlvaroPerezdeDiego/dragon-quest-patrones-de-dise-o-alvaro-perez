package com.taller.patrones.domain;


/**
 * Representa un personaje en combate.
 */
public class Character {

    private final String name;
    private int currentHp;
    private final int maxHp;
    private final int attack;
    private final int defense;
    private final int speed;

    /*
    Aquí iría un @Builder para poder usar el patrón builder que implementa lombok.
    He tenido muchos problemas al intentar añadir la etiqueta y no he conseguido que me funcione.
    El error que me daba todo el rato es el siguiente:
    java: java.lang.ExceptionInInitializerError
    com.sun.tools.javac.code.TypeTag :: UNKNOWN

    Por lo que he visto es un error con la version de lombok y de java, pero no he podido actualizar lombok
    me da cosilla cambiar el SDK
    */

    public Character(String name, int maxHp, int attack, int defense, int speed) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public void takeDamage(int damage) {
        this.currentHp = Math.max(0, currentHp - damage);
    }

    public boolean isAlive() {
        return currentHp > 0;
    }

    public double getHpPercentage() {
        return maxHp > 0 ? (double) currentHp / maxHp * 100 : 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }
}
