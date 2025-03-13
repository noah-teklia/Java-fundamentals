package _02_oop_projects._05_exception_handling._01_library;

import _02_oop_projects._05_exception_handling._01_library.model.LibraryItem;
import _02_oop_projects._05_exception_handling._01_library.model.User;

public class LibraryManagementSystem {
    public static LibraryItem[] libraryItems = new LibraryItem[10];
    public static User[] users = new User[10];
    public static int libraryCount;
    public static int userCount;
    public final static int MAX_BORROW_LIMIT = 3;

    public void addLibraryItem(LibraryItem item) {
        if (libraryCount < libraryItems.length) {
            libraryItems[libraryCount++] = item;
            System.out.println("Item added to the store successfully");

        } else {
            System.out.println("Store is full.");
        }
    }

    public void addUsers(User user) {
        if (userCount < users.length) {
            users[userCount++] = user;
            System.out.println("User added successfully");

        } else {
            System.out.println("User data store is full.");
        }
    }

    public User findUser(String userID) {
        if (userCount > 0) {
            for (int i = 0; i < userCount; i++) {
                if (users[i].getUserID().equals(userID)) {
                    return users[i];
                }

            }
        }


        return null;

    }

    public LibraryItem findLibraryItem(String itemID) {
        if (libraryCount > 0) {
            for (int i = 0; i < libraryCount; i++) {
                if (libraryItems[i].getItemID().equals(itemID)) {
                    return libraryItems[i];
                }

            }
        }
        return null;
    }

    public void viewAllUsers() {
        if (userCount > 0) {
            for (int i = 0; i < userCount; i++) {
                System.out.println((i + 1) + "." + users[i]);

            }
        } else {
            System.out.println("No user to display");
        }
    }

    public void viewAllItems() {
        if (libraryCount > 0) {
            for (int i = 0; i < libraryCount; i++) {
                System.out.println((i + 1) + "." + libraryItems[i]);

            }
        } else {
            System.out.println("No Library item to display");
        }
    }


}
