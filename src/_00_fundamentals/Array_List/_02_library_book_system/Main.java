package _00_fundamentals.Array_List._02_library_book_system;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Book book = new Book(111, "ABC", "JOHN", true);
        Book book1 = new Book(112, "xyz", "Noah", true);
        Book book2 = new Book(113, "jkl", "temie", true);
        Book book3 = new Book(114, "mnp", "David", true);


        List<Book> books = List.of(book, book1, book2, book3);
        for (Book item : books) {
            if (librarySystem.addBook(item)) {
                System.out.println("Book is added successfully");
            } else {
                System.out.println("Something went wrong.Please try again");
            }


        }

        System.out.print("Enter the Book title: ");
        String bookTitle = scanner.nextLine();

        Book searchedBook = librarySystem.findBookByTitle(bookTitle);
        if (searchedBook != null) {
            searchedBook.displayDetails();
        } else {
            System.out.println("Book is not available in our data Store");
        }

        try {
            System.out.print("Enter the Book ID: ");
            int bookID = scanner.nextInt();
            scanner.nextLine();

            Book searchBookById = librarySystem.findBookById(bookID);
            searchBookById.displayDetails();

        } catch (Exception e) {
            System.out.println("Something went wrong.Book is not available");
        }

        boolean status = librarySystem.borrowBook(112);
        if (status) {
            System.out.println("Book is successfully borrowed");
        } else {
            System.out.println("Book is not available");
        }

        if(librarySystem.returnBook(114)){
            System.out.println("Book is successfully returned");

        }else {
            System.out.println("Book is not borrowed");
        }


    }
}
