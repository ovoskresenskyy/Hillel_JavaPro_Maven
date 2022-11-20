package org.example.HW_16.services;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.HW_16.model.PetShelter;

import java.io.File;
import java.io.IOException;

public class PetShelterSerializer {

    private static final JsonMapper JSON_MAPPER = new JsonMapper();

    public static void saveToStorage(String path, PetShelter petShelter) {

        try {
            JSON_MAPPER.writeValue(new File(path), petShelter);
        } catch (IOException e) {
            System.out.println("Can't save Pet shelter state into the file!");
        }
    }

    public static PetShelter restoreFromStorage(String path) {

        try {
            return JSON_MAPPER.readValue(new File(path), PetShelter.class);
        } catch (IOException e) {
            System.out.println("Nothing to restore. Created new pet shelter storage.");
            return new PetShelter();
        }
    }
}
