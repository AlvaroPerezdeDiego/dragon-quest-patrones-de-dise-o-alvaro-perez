package com.taller.patrones.domain;

import com.taller.patrones.domain.attacks.*;
import com.taller.patrones.domain.concreteCreators.*;

public abstract class AttackFactory {
    public abstract Attack getAttack();
    public static AttackFactory getConcreteCreator(String name) {
        String n = name != null ? name.toUpperCase() : "";
        return switch (n) {
            case "TACKLE" -> new TackleCreator();
            case "SLASH" -> new SlashCreator();
            case "FIREBALL" -> new FireballCreator();
            case "ICE_BEAM" -> new IceBeamCreator();
            case "POISON_STING" -> new PoisonStingCreator();
            case "THUNDER" -> new ThunderCreator();
            case "METEOR" -> new MeteoroCreator();
            default -> new GolpeCreator();
        };
    }
}
