package _02_oop_projects._06_file_handling.student;

import java.io.IOException;
import java.util.List;

public class StudentMenu extends Menu {

    List<String> MENU_OPTIONS = List.of("Add students", "Display students", "Update student information", "Delete a student", " Exit");

    StudentService studentService=new StudentServiceImpl();
    @Override
    public void displayMenu() {
        while (true) {
            for (int i = 0; i < MENU_OPTIONS.size(); i++) {
                System.out.println((i + 1) + ". " + MENU_OPTIONS.get(i));

            }
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice==5){
                System.out.println("Exiting the program");
                break;
            }
            try {
                handleChoice(choice);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }


    }

    public void handleChoice(int choice) throws IOException,StudentNotFoundException {

        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                getAllStudents();
                break;
            case 3:
                updateStudent();
                break;
            case 4:
                deleteStudent();
                break;

            default:
                System.out.println("Invalid choice. Please try valid input");


        }



    }
    public void addStudent() throws IOException {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.println("Course List: ");


        Course course = null;


        while (true) {
            for (Course value : Course.values()) {
                System.out.println(" " + value);

            }

            System.out.print("Enter Course Name: ");
            String strCourse = scanner.nextLine();
            try{
                course = Course.fromString(strCourse);
                break;
            } catch (Exception e) {
                System.out.println("You selected invalid choice,please select a valid course name");
            }


        }


        System.out.print("Enter student Marks: ");
        int marks = scanner.nextInt();

        Student student = new Student(id, name, course, marks);
        studentService.addStudent(student);
        System.out.println("student added successfully");




    }
    public void getAllStudents()throws IOException{
        List<Student> students = studentService.getAllStudents();

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));

        }

    }
    public void updateStudent() throws IOException,StudentNotFoundException{
        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New name: ");
        String newName = scanner.nextLine();

        System.out.println("Course List: ");

        for (Course value : Course.values()) {
            System.out.println(" " + value);

        }

        System.out.print("Enter New Course Name: ");
        String strNewCourse = scanner.nextLine();
        Course newCourse = Course.fromString(strNewCourse);


        System.out.print("Enter New Marks: ");
        int newMarks = scanner.nextInt();

        studentService.updateStudent(studentID, newName, newCourse, newMarks);
        System.out.println("Student with ID " + studentID + " updated successfully");



    }
    public void deleteStudent() throws IOException,StudentNotFoundException{
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        studentService.deleteStudent(id);
        System.out.println("Student with ID " + id + " deleted successfully");


    }


}
