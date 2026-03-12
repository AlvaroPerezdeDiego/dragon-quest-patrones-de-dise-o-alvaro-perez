package com.taller.patrones.domain.attacks;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackCommand;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.MyRandom;
import com.taller.patrones.domain.attackTypes.CriticNormalAttackType;
import com.taller.patrones.domain.attackTypes.NormalAttackType;
import com.taller.patrones.domain.attackTypes.SpecialAttackType;

public class Slash extends Attack implements AttackCommand {

    public Slash () {
        super("Slash", 55, AttackType.NORMAL);
    }

    @Override
    public int execute(com.taller.patrones.domain.Character attacker, Character defender) {
        if (MyRandom.getInstance().nextDouble() < 0.2) {
            setStrategy(new CriticNormalAttackType());
        } else {
            setStrategy(new SpecialAttackType());
        }
        return getStrategy().calculateDamage(attacker, defender, this);
    }
}