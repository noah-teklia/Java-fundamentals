package _02_oop_projects._06_file_handling.library;

import _02_oop_projects._01_basic._03_studentMS.Student;
import _02_oop_projects._06_file_handling.student.StudentNotFoundException;

import java.io.IOException;
import java.util.List;

public interface LibraryService {

     void addBook(Book book) throws IOException;
     List<Book> getAllBooks() throws IOException;
     void updateBook(int id, String newTitle, String newAuthor, Genre newGenre, int newCopies) throws IOException,BookNotFoundException;
     void deleteBook(int id) throws IOException,BookNotFoundException;
}
