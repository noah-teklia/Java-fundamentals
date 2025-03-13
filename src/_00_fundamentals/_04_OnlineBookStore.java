package _00_fundamentals;

import java.util.Scanner;

public class _04_OnlineBookStore {

    static Scanner scanner = new Scanner(System.in);

    static String[] emails = new String[10];
    static String[] passwords = new String[10];
    static String[] roles = new String[10];
    static String[] statuses = new String[10];
    static int userCount = 2;

    static String loggedInUser = "";
    static boolean isAdmin = false;
    static int loggedInIndex = -1;

    static String[] bookTitles = new String[30];
    static double[] bookPrices = new double[30];
    static int[] bookStocks = new int[30];
    static int bookCount = 2;

    static String[][] purchasedBooks = new String[10][5];
    static int[] purchasedCount = new int[10];


    static int passwordCount = 0;
    static int maximumPasswordCount = 3;

    public static void main(String[] args) {

        registerDefaultUsers();
        registerDefaultBooks();

        while (true) {
            System.out.println("-- Welcome to the Online Bookstore ---");
            System.out.println("1. Signup");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    signup();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exitting from the system ");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again");

            }

        }


    }

    private static void signup() {
        System.out.println("Signup");

        System.out.print("Enter your email:");
        String email = scanner.nextLine();

        if (!email.contains("@")) {
            System.out.println("Invalid email format.Please try again ");
            return;
        }

        // Check if email is already taken
        for (int i = 0; i < userCount; i++) {
            if (emails[i].equalsIgnoreCase(email)) {
                System.out.println("Email is already exists. Please try another one");
                return;
            }
        }

        String newPassword = "";

        while (true) {

            System.out.print("Enter your password (min 6 chars): ");
            newPassword = scanner.nextLine();

            if (newPassword.length() < 6) {
                System.out.println("Password is short.Please try again ");
                continue;
            }

            System.out.print("Confirm password: ");
            String confirmPassword = scanner.nextLine();

            if (!newPassword.equals(confirmPassword)) {
                System.out.println("Password does not match.Please try again ");
                passwordCount++;

                if (passwordCount == maximumPasswordCount) {
                    System.out.println("Maximum attempt " + maximumPasswordCount + " reached ");
                    passwordCount = 0;
                    return;

                }
            } else {
                passwordCount = 0;
                break;
            }
        }

        System.out.println("Enter your role (admin/customer):");
        String role = scanner.nextLine();

        if (!role.equalsIgnoreCase("admin") && !role.equalsIgnoreCase("customer")) {
            System.out.println("Invalid user type. Please put either 'admin' or 'customer'");
            return;
        }

        emails[userCount] = email;
        passwords[userCount] = newPassword;
        roles[userCount] = role;
        statuses[userCount] = "active";
        userCount++;


        System.out.println("Sign-up successful! You can now log in.");
    }


    private static void login() {
        System.out.println("Login");

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password:");
        String password = scanner.nextLine();

        boolean isAuthenticated = false;

        for (int i = 0; i < userCount; i++) {
            if (emails[i].equalsIgnoreCase(email) && passwords[i].equals(password)) {
                if (statuses[i].equals("deactivated")) {
                    System.out.println("Your account is deactivated. Contact admin");
                    return;
                }

                loggedInUser = email;
                isAuthenticated = true;
                isAdmin = roles[i].equals("admin");
                loggedInIndex = i;
                System.out.println("Sign in successfully as " + (isAdmin ? "admin" : "customer"));
                break;
            }

        }

        if (!isAuthenticated) {
            System.out.println("Invalid email or password ");
            return;
        }

        if (isAdmin) {
            adminMenu();
        } else {
            customerMenu();
        }
    }


    private static void registerDefaultUsers() {
        emails[0] = "admin@gmail.com";
        passwords[0] = "admin";
        roles[0] = "admin";
        statuses[0] = "active";

        emails[1] = "customer1@gmail.com";
        passwords[1] = "customer";
        roles[1] = "customer";
        statuses[1] = "active";
    }

    private static void registerDefaultBooks() {
        bookTitles[0] = "Harry Potter and the Chamber of Secrets ";
        bookPrices[0] = 25.00;
        bookStocks[0] = 10;
        bookTitles[1] = "The runaway Jury ";
        bookPrices[1] = 45.00;
        bookStocks[1] = 6;


    }

    private static void adminMenu() {

        System.out.println("Admin Menu");
       /* --- Admin Menu ---
                1. Add Book
        2. Update Book Stock
        3. View All Users
        4. Deactivate User
        5. Reactivate User
        6. Log Out
        Enter your choice: 3

        */

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Update Book Stock");
            System.out.println("3. View All Users");
            System.out.println("4. Deactivate User");
            System.out.println("5. Reactivate User");
            System.out.println("6. Log Out");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    viewAllUsers();
                    break;
                case 4:
                    deactivateUsers();
                    break;
                case 5:
                    reactivateUsers();
                    break;
                case 6:
                    System.out.println("Logging out .....");
                    return;
                default:
                    System.out.println("Invalid Input. Please choose from 1-6.");

            }
        }

    }

    private static void customerMenu() {
        System.out.println("Customer Menu");
        /*
        --- Customer Menu ---
1. View Books
2. Purchase Book
3. View Purchased Books
4. Return Book
5. Log Out
Enter your choice: 1

         */
        while (true) {

            System.out.println("1. View Books");
            System.out.println("2. Purchase Book");
            System.out.println("3. View Purchased Books");
            System.out.println("4. Return Book");
            System.out.println("5. Log Out");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    purchaseBooks();
                    break;
                case 3:
                    viewPurchasedBooks();
                    break;
                case 4:
                    returnBook();
                    break;

                case 5:
                    System.out.println("Logging out...... ");
                    return;

                default:
                    System.out.println("Invalid input. please choose from 1-5");


            }


        }
    }

    private static void viewBooks() {
        if (bookCount == 0) {
            System.out.println("There is no book to view in the stock");
        } else {
            System.out.println("-----Book list-----");
            for (int i = 0; i < bookCount; i++) {
                System.out.println((i + 1) + "." + "Book Title: " + bookTitles[i] + ", Priced: $" + bookPrices[i] + " (Stock: " + bookStocks[i] + ")");


            }
        }

    }

    private static void purchaseBooks() {
        viewBooks();
        System.out.print("Select index number: ");
        int bookIndex = scanner.nextInt() - 1;

        if (bookIndex >= 0 && bookIndex < bookCount && bookStocks[bookIndex] > 0) {

            purchasedBooks[loggedInIndex][purchasedCount[loggedInIndex]] = bookTitles[bookIndex];
            purchasedCount[loggedInIndex]++;
            bookStocks[bookIndex]--;

            System.out.println("You purchased " + bookTitles[bookIndex]);

            /*
            purchase count[0,0,0,0,0,0,0,0,0,0]
            purchase count[0,0,1,0,0,0,0,0,0,0]
            purchase count[0,0,2,0,0,0,0,0,0,0]
            loggedInIndex[0.....9]  --2---
            purchasedbooks[2][purchasedCount[2]]=purchasedCount[2][0]
              00 01 02
              10 11 12
              20 21 22


              00 01 02
              10 11 12
              BT 21 22

              00 01 02
              10 11 12
              BT BT 22


    */
        } else {
            System.out.println("Invalid Index or Out of Stock ");
        }

    }

    private static void viewPurchasedBooks() {
        if (purchasedCount[loggedInIndex] == 0) {
            System.out.println("You have not purchased any book ");
        } else {
            System.out.println("Purchased book ");

            for (int i = 0; i < purchasedCount[loggedInIndex]; i++) {
                System.out.println((i + 1) + ". " + purchasedBooks[loggedInIndex][i]);
            }
        }


    }

    private static void returnBook() {

        viewPurchasedBooks();
        if(purchasedCount[loggedInIndex]==0){
            return;
        }

        System.out.print("Enter the book Index: ");
        int bookIndex = scanner.nextInt() - 1;

        if (bookIndex >= 0 && bookIndex < purchasedCount[loggedInIndex]) {
            String bookToReturn = purchasedBooks[loggedInIndex][bookIndex];

            for (int i = bookIndex; i < purchasedCount[loggedInIndex] - 1; i++) {

                purchasedBooks[loggedInIndex][i] = purchasedBooks[loggedInIndex][i + 1];
            }
            purchasedCount[loggedInIndex]--;


            for (int i = 0; i < bookCount; i++) {
                if (bookTitles[i].equalsIgnoreCase(bookToReturn)) {
                    bookStocks[i]++;
                    System.out.println("Book returned Successfully");
                    break;
                }


            }

        } else {
            System.out.println("Invalid Index.");
        }


    }

    private static void addBook() {
        if (bookCount < bookTitles.length) {

            System.out.print("Enter the Book Title: ");
            String bookTitle = scanner.nextLine();

            System.out.print("Enter the Book Price: ");
            double bookPrice = scanner.nextDouble();

            System.out.print("Enter the Book Stock: ");
            int bookStock = scanner.nextInt();

            bookTitles[bookCount] = bookTitle;
            bookPrices[bookCount] = bookPrice;
            bookStocks[bookCount] = bookStock;

            System.out.println("Book added successfully");
            bookCount++;

        } else {
            System.out.println("Book stock is full.");
        }


    }

    private static void updateBook() {

        viewBooks();

        System.out.print("Enter the index of the books: ");
        int bookIndex = scanner.nextInt() - 1;

        if (bookIndex >= 0 && bookIndex < bookCount) {
            System.out.print("Enter New Stock value");
            int newStock = scanner.nextInt();

            bookStocks[bookIndex] = newStock;
            System.out.println("Stock Updated successfully");

        } else {
            System.out.println("Invalid Index. ");
        }


    }

    private static void viewAllUsers() {
        if (userCount == 0) {
            System.out.println("No User to display");
        } else {
            System.out.println("----Users List");
            for (int i = 0; i < userCount; i++) {
                System.out.println((i + 1) + "." + "Email: " + emails[i] + "  role: " + roles[i] + " status: " + statuses[i]);

            }
        }


    }

    private static void deactivateUsers() {
        viewAllUsers();
        System.out.print("Enter the email of the user to deactivate: ");
        String email = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (emails[i].equalsIgnoreCase(email)) {
                statuses[i] = "deactivated";
                System.out.println("User: " + email + " has been deactivated");
                return;
            }


        }
        System.out.println("User not found ");


    }

    private static void reactivateUsers() {
        viewAllUsers();
        System.out.print("Enter the email of the user to reactivate: ");
        String email = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (emails[i].equalsIgnoreCase(email)) {
                statuses[i] = "active";
                System.out.println("User: " + email + " has been reactivated");
                return;
            }


        }
        System.out.println("User not found ");

    }


}
