package com.taller.patrones.domain.attackTypes;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackTypeStrategy;
import com.taller.patrones.domain.Character;

public class NormalAttackType implements AttackTypeStrategy {
    public NormalAttackType(){}

    @Override
    public int calculateDamage(Character attacker, Character defender, Attack attack) {
        int raw = attacker.getAttack() * attack.getBasePower() / 100;
        return Math.max(1, raw - defender.getDefense());
    }
}
