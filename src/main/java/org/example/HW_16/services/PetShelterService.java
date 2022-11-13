package org.example.HW_16.services;

import org.example.HW_16.enums.Gender;
import org.example.HW_16.enums.KindOfPet;
import org.example.HW_16.model.Pet;
import org.example.HW_16.model.PetShelter;

import java.util.List;
import java.util.Scanner;

public class PetShelterService {

    private PetShelter petShelter;
    private AppPrinter appPrinter;
    private final Scanner scanner;

    public PetShelterService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {

        System.out.println("""
                == == == == == == == == == == == ==
                Pet shelter application welcomes you
                == == == == == == == == == == == ==
                """);

        initPetShelter();

        appPrinter = new AppPrinter(petShelter, this, scanner);
        appPrinter.printMainMenu();
    }

    private void initPetShelter() {
        petShelter = new PetShelter(); //todo: Восстановить из файла
    }

    public void leavePet() {

        Pet pet = registerPet();
        List<Pet> petAviary = pet.getKind() == KindOfPet.DOG ?
                petShelter.getDogsAviary() :
                petShelter.getCatsAviary();
        petAviary.add(pet);

        appPrinter.printMainMenu();
    }

    private Pet registerPet() {

        System.out.println("\nRegistration:\n");

        KindOfPet kindOfPet = chooseKindOfPet();
        Gender gender = chooseGender();

        System.out.println("Enter breed");
        String breed = scanner.next();

        return Pet.builder()
                .kind(kindOfPet)
                .gender(gender)
                .breed(breed)
                .build();
    }

    private KindOfPet chooseKindOfPet() {
        AppPrinter.printKindOfPetsToChose();

        return switch (scanner.next()) {
            case "1" -> KindOfPet.DOG;
            case "2" -> KindOfPet.CAT;
            default -> chooseKindOfPet();
        };
    }

    private Gender chooseGender() {
        AppPrinter.printGendersToChose();

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
            String userInput = scanner.next();

            if (userInput.equals("x")) {
                wrongInput = false;
                appPrinter.printTakingPetMenu();
            } else if (isInputCorrect(userInput, pets.size())) {
                wrongInput = false;
                pets.remove(Integer.parseInt(userInput) - 1);
            }
        } while (wrongInput);

        System.out.println("Thanks for taking pet!");
        appPrinter.printMainMenu();
    }
}
