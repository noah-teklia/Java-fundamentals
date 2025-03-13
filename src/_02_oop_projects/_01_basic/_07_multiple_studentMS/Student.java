package _02_oop_projects._01_basic._07_multiple_studentMS;

public class Student {
     String studentID;
    private String name;
    private double grade;

    public Student(String studentID,String name, double grade){
        this.studentID=studentID;
        this.name=name;
        this.grade=grade;

    }
    void updateGrade(double newGrade){
        if(newGrade>0 && newGrade<=4){
            grade=newGrade;
            System.out.println("Grade is updated successfully");
        }else{
            System.out.println("Invalid Grade. Please try again");
        }

    }
    void displayDetails(){
        System.out.print("Student ID: " +studentID);
        System.out.print("Name: " +name);
        System.out.println("Grade: " +grade);

    }

}
