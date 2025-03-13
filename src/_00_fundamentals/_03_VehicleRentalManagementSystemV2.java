package _00_fundamentals;

import java.util.Scanner;

public class _03_VehicleRentalManagementSystemV2 {
    /*
    Vehicle Rental Management System

Here’s the detailed interactive console output for the updated Vehicle Rental System with admin and customer functionality using arrays.
Initial Menu
When the program starts, the user sees the following options:
--- Vehicle Rental System ---
1. Sign Up
2. Login
3. Exit
Enter choice:

Sign Up Process
If the user chooses 1 for signing up, they will be prompted to provide a username and password:
--- Sign Up ---
Enter username: john
Enter password: 1234
Sign-up successful! You can now log in.

Login Process
If the user chooses 2 for login, they will be prompted to enter their username and password:
--- Login ---
Enter username: john
Enter password: 1234
Login successful!





If the user enters invalid credentials:

--- Login ---
Enter username: john
Enter password: wrongpassword
Invalid username or password.

Admin Login
When logging in as admin (assuming username is "admin" and password is "admin"), the user will be shown the Admin Menu:

--- Admin Menu ---
1. View Available Vehicles
2. Add New Vehicle
3. View Rented Vehicles
4. Logout
Enter choice:

Admin Options
View Available Vehicles: If there are no vehicles yet, the console will show:
--- Available Vehicles ---
No vehicles available.

If there are vehicles, the admin can see them listed as available:

--- Available Vehicles ---
1. Sedan
2. SUV





Add New Vehicle: The admin can add new vehicles:

Enter vehicle name: Truck
Vehicle added successfully.

View Rented Vehicles: If no vehicles have been rented, the admin will see:
--- Rented Vehicles ---
No vehicles rented.

If vehicles are rented, the admin can view them:
--- Rented Vehicles ---
1. Sedan

Logout: To log out, the admin can choose option 4:

Logged out successfully.

Customer Login
When a customer logs in, they will see the Customer Menu:
--- Customer Menu ---
1. View Available Vehicles
2. Rent Vehicle
3. View Rented Vehicles
4. Logout
Enter choice:

Customer Options
View Available Vehicles: The customer can view all available vehicles:

--- Available Vehicles ---
1. Sedan
2. SUV

Rent Vehicle: The customer can choose a vehicle to rent by entering the vehicle number. If the vehicle is available:

Enter vehicle number to rent: 1
You have successfully rented Sedan

If the customer tries to rent a vehicle that is already rented, the system will display:

Enter vehicle number to rent: 1
Sorry, the vehicle is already rented.

View Rented Vehicles: The customer can view their rented vehicles:

--- Rented Vehicles ---
1. Sedan

Logout: To log out, the customer can choose option 4:
Logged out successfully.


Example Full Session for Admin and Customer:
Admin Session Example:
Login as Admin:

--- Login ---
Enter username: admin
Enter password: admin
Login successful!

--- Admin Menu ---
1. View Available Vehicles
2. Add New Vehicle
3. View Rented Vehicles
4. Logout
Enter choice: 2

Enter vehicle name: Sedan
Vehicle added successfully.

--- Admin Menu ---
1. View Available Vehicles
2. Add New Vehicle
3. View Rented Vehicles
4. Logout
Enter choice: 1

--- Available Vehicles ---
1. Sedan

Logout Admin:

Logged out successfully.

Customer Session Example:
Login as Customer:

--- Login ---
Enter username: john
Enter password: 1234
Login successful!

--- Customer Menu ---
1. View Available Vehicles
2. Rent Vehicle
3. View Rented Vehicles
4. Logout
Enter choice: 1

--- Available Vehicles ---
1. Sedan
2. SUV

Enter vehicle number to rent: 1
You have successfully rented Sedan

--- Customer Menu ---
1. View Available Vehicles
2. Rent Vehicle
3. View Rented Vehicles
4. Logout
Enter choice: 3

--- Rented Vehicles ---
1. Sedan

Logout Customer:
Logged out successfully.
     */
    static Scanner scanner = new Scanner(System.in);
    static String[] usernames = new String[30];
    static String[] passwords = new String[30];
    static String[] types = new String[30];
    static int userCount = 2;
    static int passwordCount = 0;
    static int maximumPasswordCount = 3;
    static String loggedInUser = "";
    static boolean isAdmin = false;

    static String[] vehicleNames = new String[10];
    static int[] vehiclePlateNumbers = new int[10];
    static int[] vehicleStock = new int[10];
    static boolean[] vehicleAvailability = new boolean[10];
    static int vehicleCount = 0;

    static String[] rentedVehicles = new String[10];
    static int rentedCount = 0;


    public static void main(String[] args) {
        System.out.println("Welcome to Vehicle Rental System");
        usernames[0] = "Temie";
        passwords[0] = "1234";
        types[0] = "admin";

        usernames[1] = "Noah";
        passwords[1] = "12345";
        types[1] = "Customer";

        while (true) {

            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");
            System.out.print(" Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                login();

                if (!loggedInUser.isEmpty()) {

                    if (isAdmin) {

                        adminMenu();

                    } else {

                        customerMenu();
                    }
                }

            } else if (choice == 2) {

                signup();

            } else if (choice == 3) {

                System.out.println("Exiting....");
                break;

            } else {
                System.out.println("Invalid input.");
            }
        }


    }

    public static void login() {
        System.out.println("  Login: ");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean isAuthenticated = false;

        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equalsIgnoreCase(username) && passwords[i].equalsIgnoreCase(password)) {
                loggedInUser = username;
                isAuthenticated = true;
                isAdmin = types[i].equals("admin");
                System.out.println(" Logged in as " + (isAdmin ? "admin" : "user"));
                break;


            }


        }
        if (!isAuthenticated) {
            System.out.println("Invalid username or password ");
        }

    }

    public static void signup() {
        System.out.println("  Signup: ");
        if (userCount < usernames.length) {
            System.out.print("Enter newUsername: ");
            String newUsername = scanner.nextLine();

            for (int i = 0; i < userCount; i++) {
                String username = usernames[i];
                if (username.equalsIgnoreCase(newUsername)) {
                    System.out.print("Username is already taken. Try another one ");
                    return;
                }

            }
            String newPassword = "";


            while (true) {
                System.out.print("Enter newPassword: ");
                newPassword = scanner.nextLine();

                System.out.print(" Confirm password: ");
                String confirmpassword = scanner.nextLine();

                if (!newPassword.equals(confirmpassword)) {
                    System.out.println("Password does not match. Please try again ");
                    passwordCount++;

                    if (passwordCount == maximumPasswordCount) {
                        System.out.println("You attempted " + maximumPasswordCount + "  times");
                        passwordCount = 0;
                        return;

                    }
                } else {
                    passwordCount = 0;
                    break;
                }


            }
            System.out.print(" Enter User type (Admin/Customer):  ");
            String newType = scanner.nextLine();

            if (!newType.equalsIgnoreCase("admin") && (!newType.equalsIgnoreCase("Customer"))) {
                System.out.println("Invalid user type. Please enter 'Customer' or 'admin'");
                return;
            }

            usernames[userCount] = newUsername;
            passwords[userCount] = newPassword;
            types[userCount] = newType;

            userCount++;
            System.out.println("Signup successful, you can now Login");


        } else {
            System.out.println("User limit reached");
        }


    }

    public static void adminMenu() {


        while (true) {
            System.out.println("Admin Menu");
            System.out.println("1. View Available Vehicles ");
            System.out.println("2. Add New Vehicle ");
            System.out.println("3. View Rented Vehicles ");
            System.out.println("4. Logout");

            System.out.print(" Enter your choice:  ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                viewAvailableVehicles();

            } else if (choice == 2) {

                addNewVehicle();

            } else if (choice == 3) {

                viewRentedVehicles();


            } else if (choice == 4) {

                loggedInUser = "";
                isAdmin = false;
                System.out.println(" Logout successfully ");
                break;

            } else {
                System.out.println("Invalid choice . please try again");
            }

        }


    }

    public static void customerMenu() {
        while (true) {
            System.out.println(" Customer Menu ");
            System.out.println("1. View Available Vehicles");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. View Rented Vehicles");
            System.out.println("4. Return Vehicle");
            System.out.println("5. Logout");

            System.out.print(" Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                viewAvailableVehicles();

            } else if (choice == 2) {

                rentVehicle();

            } else if (choice == 3) {

                viewRentedVehicles();


            } else if (choice == 4) {
                returnVehicle();

            } else if (choice == 5) {

                loggedInUser = "";
                System.out.println("Logged out successfully");
                break;

            } else {
                System.out.println(" Invalid choice ");

            }
        }
    }

    public static void viewAvailableVehicles() {
        if (vehicleCount == 0) {
            System.out.println("No Vehicle available to rent");
        } else {
            System.out.println("\n----Available Vehicle list-----");
            for (int i = 0; i < vehicleCount; i++) {
                if (vehicleAvailability[i]) {
                    System.out.println((i + 1) + "." + vehicleNames[i] + "  vehicle number: " + vehiclePlateNumbers[i] + "(stock:" + vehicleStock[i] + ")");
                }


            }
        }
    }

    public static void addNewVehicle() {
        if (vehicleCount < vehicleNames.length) {

            System.out.print("Enter vehicle name: ");
            String vehicleName = scanner.nextLine();

            System.out.print("Enter vehicle Plate number:  ");
            int vehiclePlateNumber = scanner.nextInt();

            System.out.print("Enter stock quantity: ");
            int stock = scanner.nextInt();
            scanner.nextLine();

            vehicleNames[vehicleCount] = vehicleName;
            vehiclePlateNumbers[vehicleCount] = vehiclePlateNumber;
            vehicleStock[vehicleCount] = stock;
            vehicleAvailability[vehicleCount] = true;
            vehicleCount++;

            System.out.println("Vehicle added successfully ");
        } else {
            System.out.println("Vehicle list is currently full");
        }


    }

    public static void viewRentedVehicles() {

        if (rentedCount == 0) {

            System.out.println("There is no rented vehicle");

        } else {
            for (int i = 0; i < rentedCount; i++) {

                if (!vehicleAvailability[i]) {
                    System.out.println((i + 1) + "." + rentedVehicles[i]);
                }
            }
        }
    }

    public static void rentVehicle() {

        System.out.println("Enter vehicle index to rent(1 to " + vehicleCount + "):");
        int vehicleIndex = scanner.nextInt() - 1;
        if (vehicleIndex >= 0 && vehicleIndex < vehicleCount) {
            if (vehicleAvailability[vehicleIndex]) {
                vehicleAvailability[vehicleIndex] = false;
                rentedVehicles[rentedCount] = "Name: " + vehicleNames[vehicleIndex] + ", Plate Number: " + vehiclePlateNumbers[vehicleIndex];
                rentedCount++;

                System.out.println("You rent:" + "Name: " + vehicleNames[vehicleIndex] + ", Plate Number: " + vehiclePlateNumbers[vehicleIndex]);

            } else {
                System.out.println("vehicle is already rented ");
            }


        } else {
            System.out.println("Invalid index.");
        }


    }

    public static void returnVehicle() {
        if (rentedCount > 0) {

            viewRentedVehicles();

            System.out.print("Enter the Index Number :");
            int indexNumber = scanner.nextInt() - 1;

            if(indexNumber>=0 && indexNumber < rentedCount){
                String[] rentedInfo = rentedVehicles[indexNumber].split(" ");
                int plateNumber = Integer.parseInt(rentedInfo[rentedInfo.length - 1]);
                /*
                 1.Name: toyota, Plate Number: 100
                 rentedInfo=[1.Name:,toyota,Plate Number:,100]
                 */


                for (int i = 0; i < vehicleCount; i++) {

                    if (vehiclePlateNumbers[i] == plateNumber) {
                        vehicleAvailability[i] = true;
                        for (int j = indexNumber; j < rentedCount - 1; j++) {

                            rentedVehicles[j] = rentedVehicles[j + 1];


                        }

                        rentedCount--;
                        System.out.println("Vehicle returned Succesfully");
                        break;

                    }
                }


            }else{
                System.out.println("Invalid index.");
            }


        } else{
            System.out.println("No vehicles to return ");
        }


    }

}


















