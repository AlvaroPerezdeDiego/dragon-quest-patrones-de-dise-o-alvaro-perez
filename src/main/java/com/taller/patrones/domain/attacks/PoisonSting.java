package com.taller.patrones.domain.attacks;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.attackTypes.StatusAttackType;

public class PoisonSting extends Attack {

    public PoisonSting() {
        super("Fireball", 20);
    }

    @Override
    public int execute(com.taller.patrones.domain.Character attacker, Character defender) {
        setStrategy(new StatusAttackType());
        return getStrategy().calculateDamage(attacker, defender, this);
    }
}