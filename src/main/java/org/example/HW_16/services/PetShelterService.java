package org.example.HW_16.services;

import org.example.HW_16.enums.Gender;
import org.example.HW_16.enums.KindOfPet;
import org.example.HW_16.model.Pet;
import org.example.HW_16.model.PetShelter;

import java.util.List;

public class PetShelterService {

    private final ApplicationService appService;
    private final PetShelter petShelter;

    public PetShelterService(ApplicationService appService, PetShelter petShelter) {

        this.appService = appService;
        this.petShelter = petShelter;
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

        appService.applicationPrinter.printMainMenu();
    }

    private Pet registerPet() {

        Server.sendMessage("\nRegistration:\n");

        KindOfPet kindOfPet = chooseKindOfPet();
        Gender gender = chooseGender();

        Server.sendMessage("Enter breed: ");
        String breed = Server.getUserInput().toLowerCase();

        return Pet.builder()
                .kind(kindOfPet)
                .gender(gender)
                .breed(breed)
                .build();
    }

    private KindOfPet chooseKindOfPet() {
        ApplicationPrinter.printKindOfPetsToChose();

        return switch (Server.getUserInput().toLowerCase()) {
            case "1" -> KindOfPet.DOG;
            case "2" -> KindOfPet.CAT;
            default -> chooseKindOfPet();
        };
    }

    private Gender chooseGender() {
        ApplicationPrinter.printGendersToChose();

        return switch (Server.getUserInput().toLowerCase()) {
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
            String userInput = Server.getUserInput().toLowerCase();

            if (userInput.equals("0")) {
                wrongInput = false;
                appService.applicationPrinter.printTakingPetMenu();
            } else if (userInput.equals("x")) {
                appService.closeApplication();
            } else if (isInputCorrect(userInput, pets.size())) {
                wrongInput = false;
                pets.remove(Integer.parseInt(userInput) - 1);
            }
        } while (wrongInput);

        Server.sendMessage("Thanks for taking pet!");
        appService.applicationPrinter.printMainMenu();
    }
}
