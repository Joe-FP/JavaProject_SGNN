package models;

public enum CategoryType {

    WEATHER("Weather"),
    BUSINESS("Business"),
    INDUSTRY("Industry"),
    CRIME("Crime"),
    TECH("Technology"),
    ENTERTAINMENT("Entertainment"),
    WORLD("World"),
    POLITICS("Politics"),
    HEALTH("Health"),
    EDUCATION("Education");

    private String value;

    CategoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
