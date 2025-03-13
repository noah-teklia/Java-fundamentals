package _02_oop_projects._04_polymorphism._02_interfaces._03_Zoo_Management_Sys;

public class Carnivore extends Animal  {
    private String preyType;

    public Carnivore(String animalID, String name, String species, boolean isFed, String preyType) {
        super(animalID, name, species, isFed);
        this.preyType = preyType;

    }

    public String getPreyType() {
        return preyType;
    }

    public void setPreyType(String preyType) {
        this.preyType = preyType;
    }

    public Animal updateProfile(Animal animal){

        this.setAnimalID(animal.getAnimalID());
        this.setName(animal.getName());
        this.setSpecies(animal.getSpecies());
        this.setFed(animal.isFed());
        this.setPreyType(((Carnivore)animal).getPreyType());



        return this;

    }




}
