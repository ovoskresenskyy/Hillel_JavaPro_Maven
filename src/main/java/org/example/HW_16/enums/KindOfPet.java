package org.example.HW_16.enums;

public enum KindOfPet {
    CAT("Cat"),
    DOG("Dog");

    private final String name;

    KindOfPet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
