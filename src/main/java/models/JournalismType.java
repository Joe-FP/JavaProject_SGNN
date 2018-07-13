package models;

public enum JournalismType {
    BROADCAST("Broadcast"),
    COMMUNICATIONS("Communication"),
    FOREIGN("Foreign"),
    FREELANCE("Freelance"),
    INVESTIGATIVE("Investigative"),
    SPORT("Sport"),
    PUBLIC_RELATIONS("Public Realtions");

    private String journalismType;

    JournalismType(String journalismType) {
        this.journalismType = journalismType;
    }

    public String getJournalismType() {
        return journalismType;
    }
}
