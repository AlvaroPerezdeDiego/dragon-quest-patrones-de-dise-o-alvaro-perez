package com.taller.patrones.application.observers;

import com.taller.patrones.application.DamageObserver;
import com.taller.patrones.application.ParametrosAObservers;

public class LogObserver implements DamageObserver {

    @Override
    public void update(ParametrosAObservers params) {
        params.battle().log(params.attacker().getName() + " usa " + params.attack().getName()
                + " y hace " + params.damage() + " de daño a " + params.defender().getName());
    }
}
