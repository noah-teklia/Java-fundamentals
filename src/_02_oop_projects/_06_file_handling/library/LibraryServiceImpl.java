package _02_oop_projects._06_file_handling.library;

import _02_oop_projects._01_basic._03_studentMS.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    private static final String FILE_PATH = "library.txt";

    @Override
    public void addBook(Book book) throws IOException {
        Files.write(Paths.get(FILE_PATH), (book.toString() + "\n").getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

    }

    @Override
    public List<Book> getAllBooks() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
        List<Book> books = new ArrayList<>();

        for (String line : lines) {
            books.add(Book.fromString(line));
        }
        return books;
    }

    @Override
    public void updateBook(int id, String newTitle, String newAuthor, Genre newGenre, int newCopies) throws IOException, BookNotFoundException {

        List<Book> books = getAllBooks();
        boolean isFound = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.set(i, new Book(id, newTitle, newAuthor, newGenre, newCopies));
                isFound = true;
                break;
            }

        }
        if (!isFound) {
            throw new IOException("Book with ID: " + id + " not found");
        }
        saveAllBooks(books);


    }

    @Override
    public void deleteBook(int id) throws IOException, BookNotFoundException {

        List<Book> books = getAllBooks();

        boolean isDeleted = books.removeIf(book -> book.getId() == id);
        if (!isDeleted) {
            throw new BookNotFoundException("Book with ID: " + id + " not found");
        }
        saveAllBooks(books);

    }

    private void saveAllBooks(List<Book> books) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Book book : books) {
            lines.add(book.toString());

        }
        Files.write(Paths.get(FILE_PATH), lines);

    }
}
