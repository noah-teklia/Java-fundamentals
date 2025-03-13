package _02_oop_projects._04_polymorphism._02_interfaces._03_Zoo_Management_Sys;

import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Animal[] animals = new Animal[10];
    static int animalCount;

    public static void main(String[] args) {

        try {
            while (true) {
                System.out.println("Options:\n" +
                        "1. Add Carnivore\n" +
                        "2. Add Herbivore\n" +
                        "3. Feed Animal\n" +
                        "4. Clean Animal Enclosure\n" +
                        "5. View Animal Details\n" +
                        "6. Update profile\n" +
                        "7. Exit");
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        addCarnivore();
                        break;
                    case 2:
                        addHerbivore();
                        break;
                    case 3:
                        feedAnimal();
                        break;
                    case 4:
                        cleanAnimalEnclosure();
                        break;
                    case 5:
                        viewAnimalDetails();
                        break;
                    case 6:
                        updateProfile();
                        break;
                    case 7:
                        System.out.println("Exit...");
                        return;
                    default:
                        System.out.println("Invalid choice");

                }
            }


        } catch (Exception e) {
            System.out.println("Invalid input,Please enter a integer number");

        }

    }

    public static void addCarnivore() {
        if (animalCount < animals.length) {
            System.out.print("Enter Animal ID: ");
            String animalID = input.nextLine();

            System.out.print("Enter Name: ");
            String name = input.nextLine();

            System.out.print("Enter Species: ");
            String species = input.nextLine();

            System.out.print("Enter IS Fed(true/false): ");
            boolean isFed = input.nextBoolean();
            input.nextLine();

            System.out.print("Enter PreyType: ");
            String preyType = input.nextLine();

            Animal animal = new Carnivore(animalID, name, species, isFed, preyType);
            animals[animalCount++] = animal;

            System.out.println("Carnivore added successfully");

        } else {
            System.out.println("Animal list is full");
        }
    }

    public static void addHerbivore() {
        if (animalCount < animals.length) {
            System.out.print("Enter Animal ID: ");
            String animalID = input.nextLine();

            System.out.print("Enter Name: ");
            String name = input.nextLine();

            System.out.print("Enter Species: ");
            String species = input.nextLine();

            System.out.print("Enter IS Fed(true/false): ");
            boolean isFed = input.nextBoolean();
            input.nextLine();

            System.out.print("Enter PlantType: ");
            String plantType = input.nextLine();

            Animal animal = new Herbivore(animalID, name, species, isFed, plantType);
            animals[animalCount++] = animal;

            System.out.println("Herbivore added successfully");

        } else {
            System.out.println("Animal List is full");
        }
    }

    public static void feedAnimal() {

        if (animalCount > 0) {
            System.out.print("Enter Animal ID: ");
            String animalID = input.nextLine();

            boolean isFound = false;

            for (int i = 0; i < animalCount; i++) {

                if (animals[i].getAnimalID().equals(animalID)) {
                    isFound = true;
                    animals[i].feedAnimal();
                    break;

                }

            }
            if (!isFound) {
                System.out.println("Animal is not found");
            }
        } else {
            System.out.println("There is no animal in the store");
        }


    }

    public static void cleanAnimalEnclosure() {
        if (animalCount > 0) {
            System.out.print("Enter Animal ID: ");
            String animalID = input.nextLine();

            boolean isFound = false;

            for (int i = 0; i < animalCount; i++) {

                if (animals[i].getAnimalID().equals(animalID)) {
                    isFound = true;
                    animals[i].cleanEnclosure();
                    break;

                }

            }
            if (!isFound) {
                System.out.println("Animal is not found");
            }
        }
    }

    public static void viewAnimalDetails() {
        if (animalCount > 0) {
            System.out.print("Enter Animal ID: ");
            String animalID = input.nextLine();

            boolean isFound = false;

            for (int i = 0; i < animalCount; i++) {

                if (animals[i].getAnimalID().equals(animalID)) {
                    isFound = true;
                    animals[i].displayAnimalDetails();
                    break;

                }

            }
            if (!isFound) {
                System.out.println("Animal is not found");
            }
        }

    }

    public static void updateProfile() {
        if (animalCount > 0) {
            System.out.print("Enter Animal ID: ");
            String animalID = input.nextLine();

            boolean isFound = false;

            for (int i = 0; i < animalCount; i++) {

                if (animals[i].getAnimalID().equals(animalID)) {
                    Animal animal = animals[i];
                    isFound = true;
                    if (animals[i] instanceof Carnivore) {
                        //Prompt fields to update(ex name,......preytype
                        //option 1: use setters ex: animals[i].setName(name)
                        //option 2: add method updateProfile(String name, String species, boolean isFed, String preyType) in the Carnivore Class


                        System.out.print("Enter Animal ID: ");
                        String animalId = input.nextLine();

                        System.out.print("Enter name: ");
                        String name = input.nextLine();

                        System.out.print("Enter Species: ");
                        String species = input.nextLine();

                        System.out.print("Enter isFed(true/false): ");
                        boolean isFed = input.nextBoolean();

                        System.out.print("Enter Prey Type: ");
                        String preyType = input.nextLine();

                        Animal updatedCarnivore = new Carnivore(animalID, name, species, isFed, preyType);
                        animals[i] = animal.updateProfile(updatedCarnivore);

                        //  animal.setName(name);
                        // animal.setAnimalID(animalId);
                        //  animal.setSpecies(species);
                        // ((Carnivore) animal).setPreyType(preyType);
                        // animal.setFed(isFed);


                        System.out.println("Carnivore updated successfully");

                    } else if (animals[i] instanceof Herbivore) {

                        System.out.print("Enter Animal ID: ");
                        String animalId = input.nextLine();

                        System.out.print("Enter name: ");
                        String name = input.nextLine();

                        System.out.print("Enter Species: ");
                        String species = input.nextLine();

                        System.out.print("Enter isFed(true/false): ");
                        boolean isFed = input.nextBoolean();

                        System.out.print("Enter Plant Type");
                        String plantType = input.nextLine();

                    }
                    break;

                }

            }
            if (!isFound) {
                System.out.println("Animal is not found");
            }
        }


    }

}
