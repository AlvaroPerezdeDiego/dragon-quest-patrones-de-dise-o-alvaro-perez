package com.taller.patrones.domain.concreteCreators;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackFactory;
import com.taller.patrones.domain.attacks.Golpe;

public class GolpeCreator extends AttackFactory {
    @Override
    public Attack getAttack() {
        return new Golpe();
    }
}