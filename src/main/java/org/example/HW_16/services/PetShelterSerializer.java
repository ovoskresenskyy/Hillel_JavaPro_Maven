package org.example.HW_16.services;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.HW_16.model.PetShelter;

import java.io.File;
import java.io.IOException;

public class PetShelterSerializer {

    private final JsonMapper JSONMapper = new JsonMapper();
    private final String path = "src/main/resources/HW_16/petShelter.json";

    public void serialize(PetShelter petShelter) {

        try {
            JSONMapper.writeValue(new File(path), petShelter);
        } catch (IOException e) {
            System.out.println("Can't create file!");
        }
    }

    public PetShelter deserialize() {

        try {
            return JSONMapper.readValue(new File(path), PetShelter.class);
        } catch (IOException e) {
            return new PetShelter();
        }
    }
}
