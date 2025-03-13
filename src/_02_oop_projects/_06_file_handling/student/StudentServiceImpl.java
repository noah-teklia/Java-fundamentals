package _02_oop_projects._06_file_handling.student;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private static final String FILE_PATH = "students.txt";

    @Override
    public void addStudent(Student student) throws IOException {
        Files.write(Paths.get(FILE_PATH), (student.toString() + "\n").getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

    }

    @Override
    public List<Student> getAllStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));

        for (String line : lines) {
            students.add(Student.fromString(line));
        }


        return students;
    }

    @Override
    public void updateStudent(int id, String newName, Course newCourse, int newMarks) throws IOException, StudentNotFoundException {

        List<Student> students = getAllStudents();
        boolean isFound = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, new Student(id, newName, newCourse, newMarks));
                isFound = true;
                break;

            }

        }
        if (!isFound) {
            throw new StudentNotFoundException("Student ID" + id + " not found");
        }
        saveAllStudents(students);

    }

    @Override
    public void deleteStudent(int id) throws IOException, StudentNotFoundException {

        List<Student> students = getAllStudents();

        boolean isDeleted = students.removeIf(student -> student.getId() == id);
        if (!isDeleted) {
            throw new StudentNotFoundException("Student ID" + id + " not found");
        }
        saveAllStudents(students);

    }

    private void saveAllStudents(List<Student> students) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Student student : students) {
            lines.add(student.toString());

        }
        Files.write(Paths.get(FILE_PATH), lines);

    }
}
