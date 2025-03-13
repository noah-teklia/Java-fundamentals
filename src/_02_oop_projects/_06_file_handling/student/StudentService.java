package _02_oop_projects._06_file_handling.student;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    void addStudent(Student student) throws IOException;
    List<Student> getAllStudents() throws IOException;
    void updateStudent(int id, String newName, Course newCourse, int newMarks) throws IOException, StudentNotFoundException;
    void deleteStudent(int id) throws IOException, StudentNotFoundException;
}
