package _00_fundamentals;

import java.util.Scanner;

public class _01_LibraryManagementSystem {
    //Inputting values
    static Scanner scanner = new Scanner(System.in);

    //users db(arrays)                                0        1         2       --->99
    static String[] usernames = new String[100]; // {"user1", "user2", "admin".....}
    static String[] passwords = new String[100]; // {"pass1", "pass2", "admin".....}
    static String[] types = new String[100];     //  {"user", "admin", "admin".....}
    static int userCount = 2;

    // Who is logged in
    static String loggedInUser = "";
    static boolean isAdmin = false;




    // Arrays for storing books
    static String[] bookTitles = new String[10];
    static String[] bookAuthors = new String[10];
    static int[] bookStock = new int[10];
    static int bookCount = 0;


    // Arrays for borrowed books
    static String[] borrowedBooks = new String[10];
    static int borrowCount = 0;






    public static void main(String[] args) {
        // Default users
        usernames[0] = "admin1";  // users: ["admin1", null, null.....]
        passwords[0]="admin1";    // passwords: ["admin1", null, null.....]
        types[0] = "admin";       // types: ["admin", null, null.....]

        usernames[1] = "user1"; // users: ["admin1", "user1", null.....]
        passwords[1]="user1";   // passwords: ["admin1", "user1", null.....]
        types[1]="user";         // types: ["admin", "user", null.....]

        System.out.println("---Welcome to Library Management System----");

        while(true) {
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1) {
                login();
                if(!loggedInUser.isEmpty()) {
                    if(isAdmin) {
                        adminMenu();

                    } else {
                        userMenu();
                    }
                }
            } else if(choice == 2) {
                signup();
            } else if(choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void login() {

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean isAuthenticated = false;

        for (int i = 0; i < userCount; i++) {
            if(usernames[i].equalsIgnoreCase(username) && passwords[i].equals(password)) {
                loggedInUser = username;
                isAuthenticated = true;

                isAdmin = types[i].equals("admin");  // returns true or false
                System.out.println("Signed in as " + (isAdmin ? "Admin" : "User"));
                break;


            }

        }

        if(!isAuthenticated) {
            System.out.println("Invalid username or password.");
        }
    }

    private static void signup() {
        System.out.println("--- SIGN UP ---");

        if(userCount < usernames.length) {
            System.out.print("Enter new username: ");
            String newUsername = scanner.nextLine();

            // Check if username is already taken or not
            for (int i=0; i < userCount; i++) {
                String username = usernames[i];
                if(username.equalsIgnoreCase(newUsername)) {
                    System.out.println("Username already exists. Please try another username.");
                    return;
                }

            }


            String newPassword= "";
            int passwordCount=0;

           while(true){
               System.out.print("Enter new password: ");
                newPassword = scanner.nextLine();

               //Confirm  password:
               System.out.print("Confirm your password: ");
               String confirmPassword = scanner.nextLine();

               if(!newPassword.equals(confirmPassword)) {
                   System.out.println("Passwords do not match. Please try again.");
                   passwordCount++;
                   if(passwordCount==3){
                       System.out.println("You failed 3 times. Returning to the main menu");
                       return;


                   }

               }else{
                   break;
               }
           }

            System.out.print("Enter user type (user/admin):");
            String newType = scanner.nextLine();

            if(!newType.equalsIgnoreCase("user") && !newType.equalsIgnoreCase("admin")) {
                System.out.println("Invalid user type. Please enter 'User' or 'admin'.");
                return;
            }

            usernames[userCount] = newUsername; // usernames: ["admin1", user1, newUsername, null.....]
            passwords[userCount] = newPassword; // passwords: ["admin1", user1, newPassword, null.....]
            types[userCount] = newType;

            userCount++;
            System.out.println("Sign up successful. You can now sign in.");
        } else {
            System.out.println("User limit reached.");
        }
    }

    private static void adminMenu() {
        /*
        --- Admin Operations ---
            1. Add Book
            2. View Books
            3. View Users
            4. Logout
            Enter your choice:

         */

        while(true) {
            System.out.println(" --- Admin Operations ---");
            System.out.println(" 1. Add Book");
            System.out.println(" 2. View Books");
            System.out.println(" 3. View Users");
            System.out.println(" 4. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1) {
                addBook();
            } else if(choice == 2) {
                viewBooks();
            } else if(choice == 3) {
                viewUsers();
            } else if(choice == 4) {
                loggedInUser = "";
                isAdmin=false;
                System.out.println("Logged out successfully.");
                break;
            } else {
                System.out.println("Invalid choice!");
            }

        }

    }

    private static void userMenu() {
       /*
       --- User Operations ---
        1. View Books
        2. Borrow Book
        3. View Borrowed Books
        4. Return Book
        5. Logout
        Enter your choice:

        */
        while(true) {
            System.out.println("\n --- User Operations ---");
            System.out.println(" 1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. View Borrowed Books");
            System.out.println("4. Return Book");
            System.out.println("5. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1) {
                viewBooks();
            } else if(choice == 2) {
                borrowBook();
            } else if(choice == 3) {
                viewBorrowedBooks();
            } else if(choice == 4) {
                returnBook();
            } else if(choice == 5) {
                loggedInUser = "";
                System.out.println("Logged out successfully.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void addBook() {
        if(bookCount < bookTitles.length) {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            System.out.print("Enter book author: ");
            String author = scanner.nextLine();

            System.out.print("Enter stock quantity: ");
            int stock = scanner.nextInt();
            scanner.nextLine();

            bookTitles[bookCount] = title;
            bookAuthors[bookCount] = author;
            bookStock[bookCount] = stock;

            bookCount++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book list is currently full.");
        }
    }

    private static void viewBooks() {
       if(bookCount == 0) {
           System.out.println("No books available to rent.");
       } else {
           System.out.println("\n--- Book List ----");
           for (int i = 0; i < bookCount; i++) {
               System.out.println((i+1) + ". " + bookTitles[i] + " by " +
                       bookAuthors[i] + " (Stock: " + bookStock[i] + ")");
           }
       }
    }

    private static void viewUsers() {
        System.out.println("\n---- User List ------");
        for (int i = 0; i < userCount; i++) {
            System.out.println((i+1) + ". Username: " + usernames[i] + " - Type: " + types[i]);

        }
    }

    private static void borrowBook() {
        System.out.print("Enter book index to borrow (1 to " + bookCount + "): ");
        int bookIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if(bookIndex >= 0 && bookIndex < bookCount) {
            if(bookStock[bookIndex] > 0) {
                borrowedBooks[borrowCount] = bookTitles[bookIndex];//borrowcount----> borrowedbooks
                borrowCount++;
                bookStock[bookIndex]--; //bookIndex-------->booktitles, bookAuthors, bookstock
                System.out.println("You borrowed: " + bookTitles[bookIndex]);
            } else {
                System.out.println("Book is out of stock.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }

    private static void viewBorrowedBooks() {
        if(borrowCount == 0) {
            System.out.println("You have no borrowed books.");
        } else {
            System.out.println("\n ---- Borrowed Books List ---");
            for (int i = 0; i < borrowCount; i++) {
                System.out.println((i+1) + ". " + borrowedBooks[i]);

            }
        }
    }

    private static void returnBook() {
        if(borrowCount == 0) {
            System.out.println("You have no books to return");
        } else {
            System.out.println("\n--- Return a Book ---");
            for (int i = 0; i < borrowCount; i++) {
                System.out.println((i+1) + ". " + borrowedBooks[i]);

            }


            System.out.println("Enter the index of the book to return (1 to " + borrowCount + "): ");
            int returnIndex = scanner.nextInt() - 1;


            if(returnIndex >= 0 && returnIndex < borrowCount) {
                String returnedBookTitle = borrowedBooks[returnIndex];

                // Increase stock
                for (int i = 0; i < bookCount; i++) {
                    if(bookTitles[i].equals(returnedBookTitle)) {
                        bookStock[i]++;
                        break;
                    }

                }


                // remove the book from the list of borrowedbooks

                for (int i = returnIndex; i < borrowCount - 1 ; i++) {
                /*
                    bookTitles: [b1, b2, b3, b4, b5, b6, b7, b8, null,null]
                    bookStock: [9, 5, 9, 9, 9, 9, 9, 10, 0, 0 ]
                    bookStock: [9, 6, 9, 9, 9, 9, 9, 10, 0, 0 ]
                    borrowedBooks: [b1, b2, b3, b4, b5, b6, b7, null, null,null]
                    returnIndex = 1
                    borrowedBooks: [b1, b3, b4, b5, b6, b7, b7, null, null,null]
                    borrowCount = 7
                    returnedBookTitle = b2

                 */
                    borrowedBooks[i] = borrowedBooks[i+1];

                }

                borrowCount--;
                System.out.println("Book returned: " + returnedBookTitle);
            } else {
                System.out.println("Invalid index.");
            }


        }
    }

}