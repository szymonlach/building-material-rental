package pl.lach.spring.buildingmaterialrental.app;

import java.util.NoSuchElementException;

public enum ApplicationOptions {


    ADD_NEW_DEVICE(1, "Add new device"),
    ADD_NEW_CATEGORY(2, "Add new category"),
    ADD_NEW_PERSON(3, "Add new person"),
    FIND_DEVICE(4, "Find device"),
    REMOVE_DEVICE(5, "Remove device"),
    REMOVE_CATEGORY(6, "Remove catgory"),
    REMOVE_PERSON(7, "Remove person"),
    END(8, "End");


    private final int number;
    private final String description;

    ApplicationOptions(int number, String description) {
        this.number = number;
        this.description = description;
    }


    public static ApplicationOptions convert(int number) {
        for (ApplicationOptions option : values()) {
            if (option.number == number) return option;
        }
        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        return number + "->" + description;
    }
}
