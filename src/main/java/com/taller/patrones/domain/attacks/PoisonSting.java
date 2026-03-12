package com.taller.patrones.domain.attacks;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackCommand;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.attackTypes.NormalAttackType;
import com.taller.patrones.domain.attackTypes.StatusAttackType;

public class PoisonSting extends Attack implements AttackCommand {

    public PoisonSting() {
        super("Fireball", 20, AttackType.STATUS);
    }

    @Override
    public int execute(com.taller.patrones.domain.Character attacker, Character defender) {
        setStrategy(new StatusAttackType());
        return getStrategy().calculateDamage(attacker, defender, this);
    }
}