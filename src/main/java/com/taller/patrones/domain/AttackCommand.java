package com.taller.patrones.domain;

public interface AttackCommand {
    int execute(Character attacker, Character defender);

    String getName();
}
