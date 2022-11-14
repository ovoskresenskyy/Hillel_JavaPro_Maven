package org.example.HW_16.services;

import org.example.HW_16.model.PetShelter;

import java.util.Scanner;

public class ApplicationService {

    public static void start(){

        System.out.println("""
                == == == == == == == == == == == ==
                Pet shelter application welcomes you
                == == == == == == == == == == == ==
                """);

        new PetShelterService(initPetShelter(), new Scanner(System.in));
    }

    private static PetShelter initPetShelter() {
        return new PetShelter(); //todo: Восстановить из файла
    }

    public static void closeApplication(Scanner scanner){

        scanner.close();
        System.exit(0);
    }
}
