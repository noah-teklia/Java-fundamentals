package _02_oop_projects._04_polymorphism._01_abstractclasses._04_hospital_managementsystem;

public class Doctor extends Person {
     private String specialization;
     private double consultationFee;

     public Doctor(String personID, String name,String specialization,double consultationFee){
         super(personID,name);
         this.specialization=specialization;
         this.consultationFee=consultationFee;
     }
     @Override
    public void displayDetails(){
         System.out.println("Person ID: "+getPersonID());
         System.out.println("Name: "+getName());
         System.out.println("Specialization: "+specialization);
         System.out.println("Consultation Fee: "+consultationFee);
     }
}
