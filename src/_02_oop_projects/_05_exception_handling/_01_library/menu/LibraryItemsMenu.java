package _02_oop_projects._05_exception_handling._01_library.menu;

import _02_oop_projects._05_exception_handling._01_library.LibraryManagementSystem;
import _02_oop_projects._05_exception_handling._01_library.model.Book;
import _02_oop_projects._05_exception_handling._01_library.model.LibraryItem;

public class LibraryItemsMenu extends Menu {
    private final LibraryManagementSystem libraryManagementSystem;

    public LibraryItemsMenu(LibraryManagementSystem libraryManagementSystem) {
        this.libraryManagementSystem = libraryManagementSystem;
    }

     @Override
     public void run() {
         while (true) {
             displayMenu();
             System.out.print("Enter a choice: ");
             int choice = scanner.nextInt();
             scanner.nextLine();
             if (choice == 3) {
                 break;

             }
             handleOption(choice);
         }
     }

    @Override
    public void displayMenu() {
        System.out.println("Library Items Management:\n" +
                "1. Add Book\n" +
                "2. View All Items\n" +
                "3. Back to Main Menu");


    }

    @Override
    public void handleOption(int option) {
        switch (option) {
            case 1:
                addBook();
                break;
            case 2:
                viewAllItems();
                break;
            case 3:
                System.out.println("Back to the Main menu");
                return;
            default:
                System.out.println("invalid choice.Please try again");


        }

    }

    public void addBook() {
        System.out.println("Enter Item ID: ");
        String itemID = scanner.nextLine();

        System.out.println("Enter Title: ");
        String title = scanner.nextLine();

        System.out.println("Enter Author: ");
        String author = scanner.nextLine();

        LibraryItem book = new Book(itemID, title, false, null, author);

        libraryManagementSystem.addLibraryItem(book);
        System.out.println("Book added successfully");


    }

    public void viewAllItems() {
        libraryManagementSystem.viewAllItems();

    }
}
