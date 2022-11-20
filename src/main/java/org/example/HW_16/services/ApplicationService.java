package org.example.HW_16.services;

import org.example.HW_16.model.PetShelter;

public class ApplicationService {

    public final PetShelter petShelter;
    private static final String PATH_TO_STORE = "src/main/resources/HW_16/petShelter.json";

    public final PetShelterService petShelterService;
    public final ApplicationPrinter applicationPrinter;

    public ApplicationService() {

        petShelter = PetShelterSerializer.restoreFromStorage(PATH_TO_STORE);
        petShelterService = new PetShelterService(this, petShelter);

        Server.sendMessage("Pet shelter application welcomes you");
        applicationPrinter = new ApplicationPrinter(this, petShelterService);
        applicationPrinter.printMainMenu();
    }

    public void closeApplication() {

        PetShelterSerializer.saveToStorage(PATH_TO_STORE, petShelter);
        Server.sendMessage("Application is closed.");
        System.exit(0);
    }
}
