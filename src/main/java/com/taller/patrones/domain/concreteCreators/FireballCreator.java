package com.taller.patrones.domain.concreteCreators;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackFactory;
import com.taller.patrones.domain.attacks.Fireball;

/**
 * Llamalos factory, así se entiende mejor. También la carpeta. No pierdas una de las ventajas de los patrones -> la comunicación
 * de intenciones
 */
public class FireballCreator extends AttackFactory {
    @Override
    public Attack getAttack() {
        return new Fireball();
    }
}
