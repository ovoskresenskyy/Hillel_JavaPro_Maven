package org.example.HW_16.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PetShelter {

    private final List<Pet> dogsAviary = new ArrayList<>();
    private final List<Pet> catsAviary = new ArrayList<>();
}
