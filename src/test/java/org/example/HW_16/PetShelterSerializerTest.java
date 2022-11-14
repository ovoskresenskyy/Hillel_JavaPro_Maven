package org.example.HW_16;

import org.example.HW_16.model.PetShelter;
import org.example.HW_16.services.PetShelterSerializer;
import org.junit.Assert;
import org.junit.Test;

public class PetShelterSerializerTest {

    private final PetShelterSerializer petShelterSerializer = new PetShelterSerializer();
    private final String pathToTestStore = "src/main/resources/HW_16/petShelter_test.json";
    private final PetShelter petShelter = new PetShelter();

    @Test
    public void serializeTest(){
        petShelterSerializer.serialize(pathToTestStore, petShelter);
    }

    @Test
    public void deserializeTest(){
        Assert.assertEquals(petShelter, petShelterSerializer.deserialize(pathToTestStore));
    }
}
