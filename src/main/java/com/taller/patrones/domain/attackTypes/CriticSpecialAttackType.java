package com.taller.patrones.domain.attackTypes;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackTypeStrategy;
import com.taller.patrones.domain.Character;

public class CriticSpecialAttackType implements AttackTypeStrategy {
    @Override
    public int calculateDamage(com.taller.patrones.domain.Character attacker, Character defender, Attack attack) {
        int raw = attacker.getAttack() * attack.getBasePower() / 100;
        raw = raw + raw/2; //raw * 1.5
        int effectiveDef = defender.getDefense() / 2;
        return Math.max(1, raw - effectiveDef);
    }
}
