package org.example.HW_16.services;

import org.example.HW_16.model.PetShelter;

import java.util.Scanner;

public class ApplicationService {

    private static final PetShelterSerializer PET_SHELTER_SERIALIZER = new PetShelterSerializer();

    public static void start(){

        System.out.println("""
                == == == == == == == == == == == ==
                Pet shelter application welcomes you
                == == == == == == == == == == == ==
                """);

        new PetShelterService(PET_SHELTER_SERIALIZER.deserialize(), new Scanner(System.in));
    }

    public static void closeApplication(PetShelter petShelter, Scanner scanner){

        PET_SHELTER_SERIALIZER.serialize(petShelter);

        scanner.close();
        System.exit(0);
    }
}
