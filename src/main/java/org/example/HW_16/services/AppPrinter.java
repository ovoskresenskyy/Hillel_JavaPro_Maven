package org.example.HW_16.services;

import org.example.HW_16.model.Pet;
import org.example.HW_16.model.PetShelter;

import java.util.List;
import java.util.Scanner;

public class AppPrinter {

    private final PetShelter petShelter;
    private final PetShelterService petShelterService;
    Scanner scanner;

    public AppPrinter(PetShelter petShelter, PetShelterService petShelterService, Scanner scanner) {
        this.petShelter = petShelter;
        this.petShelterService = petShelterService;
        this.scanner = scanner;
    }

    public void printMainMenu() {

        System.out.println("\n-----------------\n"
                + "At the moment we have "
                + petShelter.getDogsAviary().size() + " dogs and "
                + petShelter.getCatsAviary().size() + " cats.\n\n"
                + "[1] Leave the pet\n"
                + "[2] Take the pet\n"
                + "[x] Exit");

        selectMainMenuItem();
    }

    private void selectMainMenuItem() {
        switch (scanner.next().toLowerCase()) {
            case "1" -> petShelterService.leavePet();
            case "2" -> printTakingPetMenu();
            case "x" -> closeApplication();
            default -> printMainMenu();
        }
    }

    public void printTakingPetMenu() {
        System.out.println("""
                [1] Take the dog
                [2] Take the cat
                [x] To the main menu""");

        selectKindOfTakingPet();
    }

    private void selectKindOfTakingPet() {
        switch (scanner.next().toLowerCase()) {
            case "1" -> printPets(petShelter.getDogsAviary());
            case "2" -> printPets(petShelter.getCatsAviary());
            case "x" -> printMainMenu();
            default -> printTakingPetMenu();
        }
    }

    private void printPets(List<Pet> pets) {
        if (pets.size() == 0) {
            System.out.println("Sorry, no pets here");
            printTakingPetMenu();
        } else {
            pets.forEach(pet -> System.out.println("["
                    + (pets.indexOf(pet) + 1)
                    + "] "
                    + pet.toString()));

            System.out.println("""
                    "[x] To the previous menu
                    Select a pet""");

            petShelterService.giveOutPet(pets); //todo: Проверить
        }
    }

    private void closeApplication() {
        scanner.close();
        System.exit(0);
    }

    public static void printGendersToChose() {
        System.out.println("""
                Choose gender:
                [1] Male
                [2] Female""");
    }

    public static void printKindOfPetsToChose() {
        System.out.println("""
                Choose kind of pet:
                [1] Dog
                [2] Cat""");
    }
}
