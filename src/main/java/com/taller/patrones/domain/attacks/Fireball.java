package com.taller.patrones.domain.attacks;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.MyRandom;
import com.taller.patrones.domain.attackTypes.CriticSpecialAttackType;
import com.taller.patrones.domain.attackTypes.SpecialAttackType;

public class Fireball extends Attack {

    public Fireball() {
        super("Fireball", 80);
    }

    @Override
    public int execute(Character attacker, Character defender) {
        if (MyRandom.getInstance().nextDouble() < 0.2) {
            setStrategy(new CriticSpecialAttackType());
        } else {
            setStrategy(new SpecialAttackType());
        }
        return getStrategy().calculateDamage(attacker, defender, this);
    }
}
