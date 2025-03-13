package _02_oop_projects._05_exception_handling._01_library.menu;

import _02_oop_projects._05_exception_handling._01_library.LibraryManagementSystem;
import _02_oop_projects._05_exception_handling._01_library.model.User;

public class UserMenu extends Menu {
    private final LibraryManagementSystem libraryManagementSystem;

    public UserMenu(LibraryManagementSystem libraryManagementSystem) {
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
        System.out.println("User Menu :\n" +
                "1. Add User\n" +
                "2. View All Users\n" +
                "3. Back to Main Menu");


    }

    @Override
    public void handleOption(int option) {
        switch (option) {
            case 1:
                addUser();
                break;
            case 2:
                viewAllUsers();
                break;
            case 3:
                System.out.println("Back to Main Menu");
                return;
            default:
                System.out.println("Invalid input.Please try again");
        }
    }

    public void addUser() {
        System.out.println("Enter User ID: ");
        String userID = scanner.nextLine();

        System.out.println("Enter Name: ");
        String name = scanner.nextLine();


        User user = new User(userID, name, 0);

        libraryManagementSystem.addUsers(user);
        System.out.println("User added successfully");


    }

    public void viewAllUsers() {
        libraryManagementSystem.viewAllUsers();

    }


}
