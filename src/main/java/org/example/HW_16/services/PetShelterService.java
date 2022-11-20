package org.example.HW_16.services;

import org.example.HW_16.enums.Gender;
import org.example.HW_16.enums.KindOfPet;
import org.example.HW_16.model.Pet;
import org.example.HW_16.model.PetShelter;

import java.util.List;
import java.util.Scanner;

public class PetShelterService {

    private final PetShelter petShelter;
    private final ApplicationPrinter appPrinter;
    private final Scanner scanner;

    public PetShelterService(PetShelter petShelter, Scanner scanner) {

        this.petShelter = petShelter;
        this.scanner = scanner;

        appPrinter = new ApplicationPrinter(petShelter, this, scanner);
        appPrinter.printMainMenu();
    }

    public int getCountOfDogs(){
        return petShelter.getDogsAviary().size();
    }

    public int getCountOfCats(){
        return petShelter.getCatsAviary().size();
    }

    public List<Pet> getDogs(){
        return petShelter.getDogsAviary();
    }

    public List<Pet> getCats(){
        return petShelter.getCatsAviary();
    }

    public void leavePet() {

        Pet pet = registerPet();
        List<Pet> petAviary = pet.getKind() == KindOfPet.DOG ? getDogs() : getCats();
        petAviary.add(pet);

        appPrinter.printMainMenu();
    }

    private Pet registerPet() {

        System.out.println("\nRegistration:\n");

        KindOfPet kindOfPet = chooseKindOfPet();
        Gender gender = chooseGender();

        System.out.print("Enter breed: ");
        scanner.nextLine();
        String breed = scanner.nextLine();

        return Pet.builder()
                .kind(kindOfPet)
                .gender(gender)
                .breed(breed)
                .build();
    }

    private KindOfPet chooseKindOfPet() {
        ApplicationPrinter.printKindOfPetsToChose();

        return switch (scanner.next()) {
            case "1" -> KindOfPet.DOG;
            case "2" -> KindOfPet.CAT;
            default -> chooseKindOfPet();
        };
    }

    private Gender chooseGender() {
        ApplicationPrinter.printGendersToChose();

        return switch (scanner.next()) {
            case "1" -> Gender.MALE;
            case "2" -> Gender.FEMALE;
            default -> chooseGender();
        };
    }

    private boolean isInputCorrect(String input, int maxValue) {
        if (input == null || input.equals("")) {
            return false;
        } else {
            try {
                int intValue = Integer.parseInt(input);
                if (intValue < 1 || intValue > maxValue) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public void giveOutPet(List<Pet> pets) {
        boolean wrongInput = true;

        do {
            String userInput = scanner.next().toLowerCase();

            if (userInput.equals("0")) {
                wrongInput = false;
                appPrinter.printTakingPetMenu();
            } else if (userInput.equals("x")) {
                ApplicationService.closeApplication();
            } else if (isInputCorrect(userInput, pets.size())) {
                wrongInput = false;
                pets.remove(Integer.parseInt(userInput) - 1);
            }
        } while (wrongInput);

        System.out.println("Thanks for taking pet!");
        appPrinter.printMainMenu();
    }
}
