package org.example.HW_16.services;

import org.example.HW_16.model.PetShelter;

import java.util.Scanner;

public class ApplicationService {

    private static PetShelterSerializer petShelterSerializer;
    private static PetShelter petShelter;
    private static Scanner scanner;

    public static void start() {

        System.out.println("""
                
                == == == == == == == == == == == ==
                Pet shelter application welcomes you
                == == == == == == == == == == == ==""");

        petShelterSerializer = new PetShelterSerializer();
        petShelter = petShelterSerializer.deserialize();
        scanner = new Scanner(System.in);
        new PetShelterService(petShelter, scanner);
    }

    public static void closeApplication() {

        petShelterSerializer.serialize(petShelter);
        scanner.close();
        System.exit(0);
    }
}
