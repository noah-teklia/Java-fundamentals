package _02_oop_projects._01_basic._02_bookLibrary;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the Book ID: ");
        String bookID = scanner.nextLine();
        System.out.print("Enter the Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the Book Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter if Book is Borrowed: ");
        boolean isBorrowed = scanner.nextBoolean();

        LibraryBook libraryBook = new LibraryBook(bookID, title, author, isBorrowed);
        libraryBook.displayDetails();

        while (true) {
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Display Book Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Starting to Borrow Book: ");
                    libraryBook.borrowBook();
                    break;
                case 2:
                    System.out.println("Returned Book: ");
                    libraryBook.returnBook();
                    break;
                case 3:
                    System.out.println("Display Book Details: ");
                    libraryBook.displayDetails();
                    break;
                case 4:
                    System.out.println("Exitting ....");
                    return;
                default:
                    System.out.println("Invalid Input .Please try from 1-4");


            }
        }
    }
}
