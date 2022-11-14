package org.example.HW_16.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.example.HW_16.enums.Gender;
import org.example.HW_16.enums.KindOfPet;

@Builder
@Data
@Jacksonized
public class Pet {

    private final KindOfPet kind;
    private final String breed;
    private final Gender gender;

    @Override
    public String toString() {
        return kind + "\n"
                + " breed: " + breed + "\n"
                + " gender: " + gender + "\n";
    }
}
