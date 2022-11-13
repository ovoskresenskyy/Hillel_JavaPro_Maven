package org.example.HW_16;

import org.example.HW_16.services.PetShelterService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PetShelterService petShelterService = new PetShelterService(scanner);
        petShelterService.start();
        scanner.close();
    }
}
