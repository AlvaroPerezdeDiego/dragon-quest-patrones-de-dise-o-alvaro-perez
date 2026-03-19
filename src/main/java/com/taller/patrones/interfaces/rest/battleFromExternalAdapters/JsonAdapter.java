package com.taller.patrones.interfaces.rest.battleFromExternalAdapters;

import com.taller.patrones.interfaces.rest.ExternalBattle;

import java.util.Map;

public class JsonAdapter implements ExternalBattle {
    Map<String, Object> oldBody;

    public JsonAdapter(Map<String, Object> oldBody) {
        this.oldBody = oldBody;
    }

    @Override
    public String getFighter1Name() {
        return (String) oldBody.getOrDefault("fighter1_name", "Héroe");
    }

    @Override
    public int getFighter1Hp() {
        return ((Number) oldBody.getOrDefault("fighter1_hp", 150)).intValue();
    }

    @Override
    public int getFighter1Atk() {
        return ((Number) oldBody.getOrDefault("fighter1_atk", 25)).intValue();
    }

    @Override
    public String getFighter2Name() {
        return (String) oldBody.getOrDefault("fighter2_name", "Dragón");
    }

    @Override
    public int getFighter2Hp() {
        return ((Number) oldBody.getOrDefault("fighter2_hp", 120)).intValue();
    }

    @Override
    public int getFighter2Atk() {
        return ((Number) oldBody.getOrDefault("fighter2_atk", 30)).intValue();
    }
}
