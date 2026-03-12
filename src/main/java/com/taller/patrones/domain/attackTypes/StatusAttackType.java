package com.taller.patrones.domain.attackTypes;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackTypeStrategy;
import com.taller.patrones.domain.Character;

public class StatusAttackType implements AttackTypeStrategy {
    @Override
    public int calculateDamage(Character attacker, Character defender, Attack attack) {
        return 0;
    }
}
