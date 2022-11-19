package org.example.HW_16.services;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.HW_16.model.PetShelter;

import java.io.File;
import java.io.IOException;

public class PetShelterSerializer {

    private final JsonMapper JSONMapper = new JsonMapper();

    public void saveToStorage(String path, PetShelter petShelter) {

        try {
            JSONMapper.writeValue(new File(path), petShelter);
        } catch (IOException e) {
            System.out.println("Can't save Pet shelter state into the file!");
        }
    }

    public PetShelter restoreFromStorage(String path) {

        try {
            return JSONMapper.readValue(new File(path), PetShelter.class);
        } catch (IOException e) {
            System.out.println("Nothing to restore. Created new pet shelter storage.");
            return new PetShelter();
        }
    }
}
