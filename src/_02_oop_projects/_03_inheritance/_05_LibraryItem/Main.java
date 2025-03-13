package _02_oop_projects._03_inheritance._05_LibraryItem;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    LibraryItem[] libraryItems = new LibraryItem[5];
    int itemCount = 0;


    public static void main(String[] args) {
        Main librarySystem = new Main();

        while (true) {
            System.out.println("Library System\n" +
                    "1. Add Book\n" +
                    "2. Add Magazine\n" +
                    "3. Add DVD\n" +
                    "4. Display All Items\n" +
                    "5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();


            switch (choice) {
                case 1:
                    librarySystem.addBook();
                    break;
                case 2:
                    librarySystem.addMagazine();
                    break;
                case 3:
                    librarySystem.addDVD();
                    break;
                case 4:
                    librarySystem.displayAll();
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again");


            }
        }

    }

    private void addBook() {
        System.out.print("Enter Title: ");
        String title = input.nextLine();

        System.out.print("Enter Author: ");
        String author = input.nextLine();

        System.out.print("Enter Genre: ");
        String genre = input.nextLine();

        LibraryItem book = new Book(title, author, genre);
        if (itemCount >= 0 && itemCount < libraryItems.length) {
            libraryItems[itemCount++] = book;
            System.out.println("Book added successfully");
        } else {
            System.out.println("Library list is full");
        }


    }

    private void addMagazine() {
        System.out.print("Enter Title: ");
        String title = input.nextLine();

        System.out.print("Enter Author: ");
        String author = input.nextLine();

        System.out.print("Enter Issue Number: ");
        int issueNumber = input.nextInt();

        LibraryItem magazine = new Magazine(title, author, issueNumber);
        if (itemCount >= 0 && itemCount < libraryItems.length) {
            libraryItems[itemCount++] = magazine;
            System.out.println("Magazine added successfully");
        } else {
            System.out.println("Library list is full");
        }

    }

    private void addDVD() {
        System.out.print("Enter Title: ");
        String title = input.nextLine();

        System.out.print("Enter Author: ");
        String author = input.nextLine();

        System.out.print("Enter Duration: ");
        double duration = input.nextDouble();

        LibraryItem dvd = new DVD(title, author, duration);
        if (itemCount >= 0 && itemCount < libraryItems.length) {
            libraryItems[itemCount++] = dvd;
            System.out.println("DVD added successfully");
        } else {
            System.out.println("Library list is full");
        }

    }

    private void displayAll() {
        if (itemCount > 0) {
            for (int i = 0; i < itemCount; i++) {
                System.out.println((i+1)+"."+ libraryItems[i]);

            }
        }


    }
}
