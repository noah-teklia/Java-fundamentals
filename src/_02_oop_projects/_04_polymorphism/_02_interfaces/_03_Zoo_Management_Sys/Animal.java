package _02_oop_projects._04_polymorphism._02_interfaces._03_Zoo_Management_Sys;

public class Animal implements AnimalCare {
    private String animalID;
    private String name;
    private String species;
    private boolean isFed;

    public Animal(String animalID, String name, String species, boolean isFed) {
        this.animalID = animalID;
        this.name = name;
        this.species = species;
        this.isFed = isFed;

    }

    public String getAnimalID() {
        return animalID;
    }

    public void setAnimalID(String animalID) {
        this.animalID = animalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean isFed() {
        return isFed;
    }

    public void setFed(boolean fed) {
        isFed = fed;
    }

    public void feedAnimal() {
        if (isFed == true) {
            System.out.println(name + " is already fed");
        } else {
            isFed = true;
            System.out.println(name + " has been fed");
        }

    }

    public void cleanEnclosure() {

        System.out.println(name + "'s enclosure has been cleaned");
    }

    public void displayAnimalDetails() {
        System.out.println("Animal ID: " + animalID);
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Fed status: " + (isFed ? "Fed" : "Not Fed"));

    }

    public Animal updateProfile(Animal animal) {

        System.out.println("Generic update Profile Method");
        return this;
    }


}
