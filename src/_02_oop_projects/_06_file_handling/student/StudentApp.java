package _02_oop_projects._06_file_handling.student;




public class StudentApp {


    static Menu menu=new StudentMenu();

    public static void main(String[] args) {
        System.out.println("************************************");
        System.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEM");
        System.out.println("************************************");

        menu.displayMenu();
    }





}
