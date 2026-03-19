package com.taller.patrones.application.observers;

import com.taller.patrones.application.DamageObserver;
import com.taller.patrones.application.ParametrosAObservers;

public class LastDamageObserver implements DamageObserver {

    @Override
    public void update(ParametrosAObservers params) {
        String target = params.defender() == params.battle().getPlayer() ? "player" : "enemy";
        params.battle().setLastDamage(params.damage(), target);
    }
}
