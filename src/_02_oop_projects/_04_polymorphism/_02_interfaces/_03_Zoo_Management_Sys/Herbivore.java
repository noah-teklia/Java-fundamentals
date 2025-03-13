package _02_oop_projects._04_polymorphism._02_interfaces._03_Zoo_Management_Sys;

public class Herbivore extends Animal {
    private String plantType;

    public Herbivore(String animalID, String name, String species, boolean isFed, String plantType) {
        super(animalID, name, species, isFed);
        this.plantType = plantType;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }
}
