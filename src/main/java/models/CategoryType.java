package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

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


    private String type;
    private List<CategoryType> enumTypes;

    CategoryType(String type) {
        this.type = type;
        this.enumTypes = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public List<CategoryType> getEnumTypes() {
        return enumTypes;
    }

    public void addEnumTypes(CategoryType categoryType){
        enumTypes.add(categoryType);
    }
}
