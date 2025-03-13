package _02_oop_projects._03_inheritance._06_school_mgt_system;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Person[] people = new Person[10];
    static int personCount = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("School Management System\n" +
                    "1. Add Student\n" +
                    "2. Add Teacher\n" +
                    "3. Add Administrator\n" +
                    "4. Display Person\n" +
                    "5. Display All Members\n" +
                    "6. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    addAdmninistrator();
                    break;
                case 4:
                    displayPerson();
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice.Please try again");

            }
        }
    }

    public static void addStudent() {
        if (personCount >= 0 && personCount < people.length) {
            System.out.print("Enter Name: ");
            String name = input.nextLine();

            System.out.print("Enter Age: ");
            int age = input.nextInt();
            input.nextLine();

            System.out.print("Enter Student ID:");
            String studentID = input.nextLine();

            Person student = new Student(name, age, studentID);
            people[personCount++] = student;
            System.out.println("Student added successfully");


        } else {
            System.out.println("People list is full");
        }

    }

    public static void addTeacher() {
        if (personCount >= 0 && personCount < people.length) {
            System.out.print("Enter Name: ");
            String name = input.nextLine();

            System.out.print("Enter Age: ");
            int age = input.nextInt();
            input.nextLine();

            System.out.print("Enter Subject:");
            String subject = input.nextLine();

            Person teacher = new Teacher(name, age, subject);
            people[personCount++] = teacher;
            System.out.println("Teacher added successfully");


        } else {
            System.out.println("People list is full");
        }


    }

    public static void addAdmninistrator() {
        if (personCount >= 0 && personCount < people.length) {
            System.out.print("Enter Name: ");
            String name = input.nextLine();

            System.out.print("Enter Age: ");
            int age = input.nextInt();
            input.nextLine();

            System.out.print("Enter Department:");
            String department = input.nextLine();

            Person administrator = new Administrator(name, age, department);
            people[personCount++] = administrator;
            System.out.println("Administrator added successfully");


        } else {
            System.out.println("People list is full");
        }

    }

    public static void displayAll() {
        if (personCount >= 0 && personCount < people.length) {
            for (int i = 0; i < personCount; i++) {
                //people[i].displayDetails();
                System.out.println((i + 1) + "." + people[i]);


            }
        } else {
            System.out.println("List is full");
        }


    }

    public static void displayPerson() {
        displayAll();
        System.out.print("Enter the index: ");
        int index = input.nextInt() - 1;

        if (index >= 0 && index < personCount) {
            people[index].displayDetails();

        } else {
            System.out.println("invalid index");
        }

    }

}
