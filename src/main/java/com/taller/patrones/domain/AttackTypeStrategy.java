package com.taller.patrones.domain;

public interface AttackTypeStrategy {
    int calculateDamage(Character attacker, Character defender, Attack attack);
}
