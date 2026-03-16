package com.taller.patrones.domain.attacks;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.MyRandom;
import com.taller.patrones.domain.attackTypes.CriticNormalAttackType;
import com.taller.patrones.domain.attackTypes.NormalAttackType;

public class Tackle extends Attack {

    public Tackle () {
        super("Tackle", 40);
    }

    @Override
    public int execute(com.taller.patrones.domain.Character attacker, Character defender) {
        if (MyRandom.getInstance().nextDouble() < 0.2) {
            setStrategy(new CriticNormalAttackType());
        } else {
            setStrategy(new NormalAttackType());
        }
        return getStrategy().calculateDamage(attacker, defender, this);
    }
}