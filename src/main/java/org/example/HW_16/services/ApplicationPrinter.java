package org.example.HW_16.services;

import org.example.HW_16.model.Pet;

import java.util.List;

public class ApplicationPrinter {

    private final ApplicationService appService;
    private final PetShelterService petShelterService;

    public ApplicationPrinter(ApplicationService appService, PetShelterService petShelterService) {
        this.appService = appService;
        this.petShelterService = petShelterService;
    }

    public void printMainMenu() {

        Server.sendMessage("\n-----------------\n"
                + "At the moment we have "
                + petShelterService.getCountOfDogs() + " dogs and "
                + petShelterService.getCountOfCats() + " cats.\n"
                + "[1] Leave the pet\n"
                + "[2] Take the pet\n"
                + "[x] Exit\n");

        selectMainMenuItem();
    }

    private void selectMainMenuItem() {

        switch (Server.getUserInput().toLowerCase()) {
            case "1" -> petShelterService.leavePet();
            case "2" -> printTakingPetMenu();
            case "x" -> appService.closeApplication();
            default -> printMainMenu();
        }
    }

    public void printTakingPetMenu() {

        Server.sendMessage("""
                [1] Take the dog
                [2] Take the cat
                [0] Back to main menu
                [x] Exit
                """);

        selectKindOfTakingPet();
    }

    private void selectKindOfTakingPet() {

        switch (Server.getUserInput().toLowerCase()) {
            case "1" -> printPets(petShelterService.getDogs());
            case "2" -> printPets(petShelterService.getCats());
            case "0" -> printMainMenu();
            case "x" -> appService.closeApplication();
            default -> printTakingPetMenu();
        }
    }

    private void printPets(List<Pet> pets) {

        if (pets.size() == 0) {
            Server.sendMessage("Sorry, no pets here");
            printTakingPetMenu();
        } else {
            pets.forEach(pet -> Server.sendMessage("["+ (pets.indexOf(pet) + 1)+ "] "+ pet.toString()));
            Server.sendMessage("""
                    [0] Back to previous menu
                    [x] Exit
                    Select a pet:
                    """);

            petShelterService.giveOutPet(pets);
        }
    }

    public static void printGendersToChose() {

        Server.sendMessage("""
                [1] Male
                [2] Female
                Choose gender:
                """);
    }

    public static void printKindOfPetsToChose() {

        Server.sendMessage("""
                [1] Dog
                [2] Cat
                Choose kind of pet:
                """);
    }
}
