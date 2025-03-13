package _02_oop_projects._02_encapsulation._08_multiple_booklibrary;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Book[] books = new Book[5];
    static int bookCount = 0;


    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "\n1. Add Book\n" +
                            "2. View All Books\n" +
                            "3. Search Book by ID\n" +
                            "4. View Book by Position\n" +
                            "5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    searchBookByID();
                    break;
                case 4:
                    viewBookByPosition();
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice. please choose valid option");
            }


        }
    }


    private static void addBook() {
        if (bookCount < books.length) {
            System.out.print("Enter Book ID:");
            String bookID = input.nextLine();

            System.out.print("Enter Title:");
            String title = input.nextLine();

            System.out.print("Enter Author:");
            String author = input.nextLine();


            Book newBook = new Book(bookID, title, author, false);
            books[bookCount++] = newBook;
            System.out.println("Book added successfully ");
        } else {
            System.out.println("Book limit is reached");
        }

    }

    private static void viewAllBooks() {
        if (bookCount == 0) {
            System.out.println("There is no book to view");
        } else {
            for (int i = 0; i < bookCount; i++) {
                System.out.print((i + 1) + ".");
                books[i].displayDetails();


            }
        }

    }

    private static void searchBookByID() {
        System.out.print("Enter Book ID: ");
        String bookId = input.nextLine();


        Book existingBook = findBookByID(bookId);

        if (existingBook != null) {
            existingBook.displayDetails();
            System.out.println();

        } else {
            System.out.println("Book is not found with the Book ID " + bookId);
        }


    }

    private static void viewBookByPosition() {

        System.out.print("Enter the Book index: ");
        int index = input.nextInt() - 1;

        if (index >= 0 && index<bookCount){
            books[index].displayDetails();
        }else{
            System.out.println("Invalid index.");
        }

    }

    private static Book findBookByID(String bookID) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookID().equals(bookID)) {
                return books[i];
            }


        }


        return null;
    }
}
