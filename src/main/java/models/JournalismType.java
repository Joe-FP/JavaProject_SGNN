package models;

import java.util.Random;

public enum JournalismType {

    Broadcast,
    Communication,
    Foreign,
    Freelance,
    Investigative,
    Sport,
    PR;

    public static JournalismType getRandomType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
