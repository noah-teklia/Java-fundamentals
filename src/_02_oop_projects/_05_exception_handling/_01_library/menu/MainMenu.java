package _02_oop_projects._05_exception_handling._01_library.menu;

import _02_oop_projects._05_exception_handling._01_library.LibraryManagementSystem;
import _02_oop_projects._05_exception_handling._01_library.model.LibraryItem;
import _02_oop_projects._05_exception_handling._01_library.model.User;

public class MainMenu extends Menu {

    private final LibraryManagementSystem libraryManagementSystem;

    public MainMenu(LibraryManagementSystem libraryManagementSystem) {
        this.libraryManagementSystem = libraryManagementSystem;

    }


    @Override
    public void displayMenu() {

        System.out.println("Library Management System Menu:\n" +
                "1. Manage Library Items\n" +
                "2. Manage Users\n" +
                "3. Borrow Item\n" +
                "4. Return Item\n" +
                "5. Exit");


    }
    @Override
    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter a choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 5) {
                break;

            }
            handleOption(choice);
        }
    }

    @Override
    public void handleOption(int option) {
        switch (option) {
            case 1:
                new LibraryItemsMenu(libraryManagementSystem).run();
                //LibraryManagementSystem LibraryItemsMenu=new LibraryItemsMenu(libraryManagementSystem);
                break;
            case 2:
                new UserMenu(libraryManagementSystem).run();
                break;
            case 3:
                borrowItem();
                break;
            case 4:
                returnItem();
                break;
            case 5:
                System.out.println("Exitting...");
                return;
            default:
                System.out.println("Invalid input.Please try again");

        }

    }

    public void borrowItem() {
        try {
            libraryManagementSystem.viewAllItems();
            System.out.println("Enter User ID: ");
            String userID = scanner.nextLine();

            System.out.println("Enter Item ID: ");
            String itemID = scanner.nextLine();

            User user = libraryManagementSystem.findUser(userID);
            if (user == null) {
                throw new Exception("User not found");

            }
            if (user.getBorrowedItemCount() == LibraryManagementSystem.MAX_BORROW_LIMIT) {
                throw new Exception("User has reached maximum borrowing limit");
            }

            LibraryItem libraryItem = libraryManagementSystem.findLibraryItem(itemID);
            if (libraryItem == null) {
                throw new Exception("Library item not found");
            }

            libraryItem.borrowItem(userID);
            user.setBorrowedItemCount(user.getBorrowedItemCount() + 1);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    public void returnItem() {
        try {
            System.out.println("Enter Item ID: ");
            String itemID = scanner.nextLine();

            LibraryItem libraryItem = libraryManagementSystem.findLibraryItem(itemID);
            if (libraryItem == null) {
                throw new Exception("Library item not found");


            }
            String userID = libraryItem.getBorrowedBy();
            User user = libraryManagementSystem.findUser(userID);
            user.setBorrowedItemCount(user.getBorrowedItemCount() - 1);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
