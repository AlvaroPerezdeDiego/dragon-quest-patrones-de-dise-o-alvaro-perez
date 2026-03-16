package com.taller.patrones.domain.concreteCreators;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackFactory;
import com.taller.patrones.domain.attacks.Fireball;

public class FireballCreator extends AttackFactory {
    @Override
    public Attack getAttack() {
        return new Fireball();
    }
}
