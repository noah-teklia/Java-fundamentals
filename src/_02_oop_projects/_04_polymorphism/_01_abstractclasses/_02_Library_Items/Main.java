package _02_oop_projects._04_polymorphism._01_abstractclasses._02_Library_Items;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static LibraryItems[] libraryItems = new LibraryItems[10];
    static int itemCount = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Options:\n" +
                    "1. Add Book\n" +
                    "2. Add DVD\n" +
                    "3. View Item Details\n" +
                    "4. Borrow Item\n" +
                    "5. Return Item\n" +
                    "6. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addDVD();
                    break;
                case 3:
                    viewItemDetails();
                    break;
                case 4:
                    borrowItem();
                    break;
                case 5:
                    returnItem();
                    break;
                case 6:
                    System.out.println("Exitting the program");
                    return;
                default:
                    System.out.println("Invalid choice");


            }
        }

    }

    public static void addBook() {
        if (itemCount < libraryItems.length) {
            System.out.print("Enter Book id:");
            String bookId = input.nextLine();

            System.out.print("Enter Book Title:");
            String bookTitle = input.nextLine();

            System.out.println("Enter Book Author: ");
            String bookAuthor = input.nextLine();

            LibraryItems book = new Book(bookId, bookTitle, bookAuthor);
            libraryItems[itemCount++] = book;

            System.out.println("Book added successfully");

        } else {
            System.out.println("Shelf is full");
        }

    }

    public static void addDVD() {
        if (itemCount < libraryItems.length) {
            System.out.print("Enter DVD id:");
            String dvdId = input.nextLine();

            System.out.print("Enter DVD Title:");
            String dvdTitle = input.nextLine();

            System.out.println("Enter DVD Director: ");
            String dvdDirector = input.nextLine();

            LibraryItems dvd = new DVD(dvdId, dvdTitle, dvdDirector);
            libraryItems[itemCount++] = dvd;

            System.out.println("DVD added successfully");

        } else {
            System.out.println("Shelf is full");
        }
    }

    public static void viewItemDetails() {
        displayAll();
        System.out.print("Enter item ID: ");
        String itemID = input.nextLine();

        boolean isFound = false;
        for (int i = 0; i < itemCount; i++) {
            if (libraryItems[i].getItemID().equals(itemID)) {
                libraryItems[i].displayItemDetails();
                isFound = true;

                break;
            }

        }

        if (!isFound) {
            System.out.println("Book with item ID " + itemID + " doesn't exist");
        }

    }

    public static void borrowItem() {
        displayAll();
        System.out.print("Enter item ID: ");
        String itemID = input.nextLine();

        boolean isFound = false;
        for (int i = 0; i < itemCount; i++) {
            if (libraryItems[i].getItemID().equals(itemID)) {
                libraryItems[i].borrowItem();
                isFound = true;

                break;
            }

        }

        if (!isFound) {
            System.out.println("Book with item ID " + itemID + " doesn't exist");
        }


    }

    public static void returnItem() {
        displayAll();
        System.out.println("Enter the index: ");
        int index = input.nextInt() - 1;

        if(index>=0 && index<itemCount){
            libraryItems[index].returnItem();

        }else{
            System.out.println("Invalid index");
        }


    }

    public static void displayAll() {
        if (itemCount > 0) {
            for (int i = 0; i < itemCount; i++) {
                System.out.println((i+1)+"."+libraryItems[i]);

            }
        }
    }


}
