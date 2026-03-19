package com.taller.patrones.interfaces.rest.battleFromExternalAdapters;

import com.taller.patrones.interfaces.rest.ExternalBattle;

import java.util.Map;

public class FormatoDistintoAdapter implements ExternalBattle {
    Map<String, Object> oldBody;

    public FormatoDistintoAdapter(Map<String, Object> oldBody) {
        this.oldBody = oldBody;
    }

    @Override
    public String getFighter1Name() {
        return (String) oldBody.getOrDefault("fighter1.name", "Héroe");
    }

    @Override
    public int getFighter1Hp() {
        return ((Number) oldBody.getOrDefault("fighter1.health", 150)).intValue();
    }

    @Override
    public int getFighter1Atk() {
        return ((Number) oldBody.getOrDefault("fighter1.attack", 25)).intValue();
    }

    @Override
    public String getFighter2Name() {
        return (String) oldBody.getOrDefault("fighter2.name", "Dragón");
    }

    @Override
    public int getFighter2Hp() {
        return ((Number) oldBody.getOrDefault("fighter2.health", 120)).intValue();
    }

    @Override
    public int getFighter2Atk() {
        return ((Number) oldBody.getOrDefault("fighter2.attack", 30)).intValue();
    }
}
