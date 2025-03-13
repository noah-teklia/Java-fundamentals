package _00_fundamentals.Array_List._02_library_book_system;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    List<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        if (book != null) {
            books.add(book);
            return true;

        }
        return false;

    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;

            }
        }

        return null;
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;

    }

    public boolean borrowBook(int id) {
        Book book = findBookById(id);

        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;

        }
        return false;


    }

    public boolean returnBook(int id) {
        Book book = findBookById(id);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;


        }
        return false;


    }

}
