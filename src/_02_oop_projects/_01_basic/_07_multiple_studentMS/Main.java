package _02_oop_projects._01_basic._07_multiple_studentMS;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Student[] students = new Student[5];
    static int studentCount = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Student\n" +
                    "2. View All Students\n" +
                    "3. Search Student by ID\n" +
                    "4. View Student by Position\n" +
                    "5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudentByID();
                    break;
                case 4:
                    viewStudentByPosition();
                    break;
                case 5:
                    System.out.println("Exitting ");
                    return;
                default:
                    System.out.println("Invalid input.Please try another ");
            }
        }

    }

    private static void addStudent() {
        if (studentCount < students.length) {
            System.out.print("Enter student ID: ");
            String studentId = input.nextLine();

            System.out.print("Enter Name : ");
            String name = input.nextLine();

            System.out.print("Enter Grade: ");
            double grade = input.nextDouble();

            Student student = new Student(studentId, name, grade);
            students[studentCount] = student;
            studentCount++;
            System.out.println("Student added successfully ");


        } else {
            System.out.println("Our datastore is currently full");
        }

    }

    private static void viewAllStudents() {
        System.out.println("View All Students ");
        if (studentCount == 0) {
            System.out.println("No students available in the datastore");
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.println((i + 1) + ".");
            students[i].displayDetails();

        }

    }

    private static void searchStudentByID() {
        System.out.print("Enter the student ID: ");
        String studentId = input.nextLine();

        Student student = findStudentByID(studentId);
        if (student != null) {
            student.displayDetails();

        } else {
            System.out.println("Student is not found with ID " + studentId);
        }

    }

    private static void viewStudentByPosition() {
        viewAllStudents();
        System.out.print("Enter the index: ");
        int index = input.nextInt() - 1;

        if (index >= 0 && index < studentCount) {
            students[index].displayDetails();

        } else {
            System.out.println("Invalid index");
        }
    }

    private static Student findStudentByID(String studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].studentID.equals(studentId)) {
                return students[i];

            }

        }
        return null;
    }


}




