package org.example.HW_16.model;

import lombok.Builder;
import org.example.HW_16.enums.Gender;
import org.example.HW_16.enums.KindOfPet;

@Builder
public class Pet {

    private final KindOfPet kind;
    private final String breed;
    private final Gender gender;

    public KindOfPet getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return kind + "\n"
                + " breed: " + breed + "\n"
                + " gender: " + gender + "\n";
    }
}
