package com.taller.patrones.application;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;

/**
 * Este nombre de clase es raro, dale una vuelta
 */
public record ParametrosAObservers(int damage, Battle battle, Character attacker, Character defender, Attack attack) {
}
