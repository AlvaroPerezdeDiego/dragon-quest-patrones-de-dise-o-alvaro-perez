package com.taller.patrones.domain.attacks;

import com.taller.patrones.domain.*;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.attackTypes.CriticNormalAttackType;
import com.taller.patrones.domain.attackTypes.CriticSpecialAttackType;
import com.taller.patrones.domain.attackTypes.NormalAttackType;
import com.taller.patrones.domain.attackTypes.SpecialAttackType;

public class Golpe extends Attack implements AttackCommand {

    public Golpe () {
        super("Golpe", 40, AttackType.NORMAL);
    }

    @Override
    public int execute(Character attacker, Character defender) {
        if (MyRandom.getInstance().nextDouble() < 0.2) {
            setStrategy(new CriticNormalAttackType());
        } else {
            setStrategy(new SpecialAttackType());
        }
        return getStrategy().calculateDamage(attacker, defender, this);
    }
}