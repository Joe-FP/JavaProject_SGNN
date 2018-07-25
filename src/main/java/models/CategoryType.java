package models;

import java.util.Random;

public enum CategoryType {
    Weather,
    Business,
    Industry,
    Crime,
    Tech,
    Entertainment,
    World,
    Politics,
    Health,
    Education,
    AI,
    DeepLearning,
    History,
    Ethics,
    Future;

    public static CategoryType getRandomType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
