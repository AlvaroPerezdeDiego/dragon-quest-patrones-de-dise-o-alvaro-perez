package com.taller.patrones.domain.attacks;

import com.taller.patrones.domain.*;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.attackTypes.CriticNormalAttackType;
import com.taller.patrones.domain.attackTypes.NormalAttackType;

public class Golpe extends Attack {

    public Golpe () {
        super("Golpe", 40);
    }

    @Override
    public int execute(Character attacker, Character defender) {
        if (MyRandom.getInstance().nextDouble() < 0.2) {
            setStrategy(new CriticNormalAttackType());
        } else {
            setStrategy(new NormalAttackType());
        }
        return getStrategy().calculateDamage(attacker, defender, this);
    }
}