package _02_oop_projects._02_encapsulation._03_studentMS;

public class Student {
    private String studentID;
    private String name;
    private double grade;

    public Student(String studentID,String name, double grade){
        this.studentID=studentID;
        this.name=name;
        this.grade=grade;

    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void updateGrade(double newGrade){
        if(newGrade>0 && newGrade<=4){
            grade=newGrade;
            System.out.println("Grade is successfully updated ");

        }else{
            System.out.println("Invalid Grade. Please try again ");
        }

    }
    public void displayDetails(){
        System.out.println("Student ID: "+ studentID);
        System.out.println("Student name: "+ name);
        System.out.println("Student Grade: "+ grade);
    }
    /*@Override
    public String toString(){
        return "Student ID: "+ studentID+", Student name: "+ name+", Student Grade: "+ grade;

    }
     */
}
