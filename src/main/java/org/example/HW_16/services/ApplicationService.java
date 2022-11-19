package org.example.HW_16.services;

import org.example.HW_16.model.PetShelter;

import java.util.Scanner;

public class ApplicationService {

    private static PetShelterSerializer petShelterSerializer;
    private static final String PATH_TO_STORE = "src/main/resources/HW_16/petShelter.json";
    private static PetShelter petShelter;
    private static Scanner scanner;

    public static void start() {

        System.out.println("""
                
                == == == == == == == == == == == ==
                Pet shelter application welcomes you
                == == == == == == == == == == == ==""");

        petShelterSerializer = new PetShelterSerializer();
        petShelter = petShelterSerializer.restoreFromStorage(PATH_TO_STORE);
        scanner = new Scanner(System.in);
        new PetShelterService(petShelter, scanner);
    }

    public static void closeApplication() {

        petShelterSerializer.saveToStorage(PATH_TO_STORE, petShelter);
        scanner.close();
        System.exit(0);
    }
}
