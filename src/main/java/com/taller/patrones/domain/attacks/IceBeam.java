package com.taller.patrones.domain.attacks;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackCommand;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.MyRandom;
import com.taller.patrones.domain.attackTypes.CriticSpecialAttackType;
import com.taller.patrones.domain.attackTypes.SpecialAttackType;

public class IceBeam extends Attack implements AttackCommand {

    public IceBeam() {
        super("IceBeam", 70, AttackType.SPECIAL);
    }

    @Override
    public int execute(com.taller.patrones.domain.Character attacker, Character defender) {
        if (MyRandom.getInstance().nextDouble() < 0.2) {
            setStrategy(new CriticSpecialAttackType());
        } else {
            setStrategy(new SpecialAttackType());
        }
        return getStrategy().calculateDamage(attacker, defender, this);
    }
}