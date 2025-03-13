package _02_oop_projects._06_file_handling.rental;

import _02_oop_projects._06_file_handling.rental.constants.UserRole;
import _02_oop_projects._06_file_handling.rental.menu.AdminMenu;
import _02_oop_projects._06_file_handling.rental.menu.CustomerMenu;
import _02_oop_projects._06_file_handling.rental.menu.Menu;
import _02_oop_projects._06_file_handling.rental.model.User;
import _02_oop_projects._06_file_handling.rental.model.UserImpl;
import _02_oop_projects._06_file_handling.rental.service.*;

import java.util.Scanner;

public class VehicleRentalSystem {

    private static final UserService userService = new UserServiceImpl();
    private static final VehicleService vehicleService = new VehicleServiceImpl();
    private static final RentalService rentalService = new RentalServiceImpl(vehicleService);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Vehicle Rental System!");

        while(true){
            System.out.println("\n1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if(option==1){
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                try{
                   User user=userService.authenticateUser(username,password);
                   if(user==null){
                       System.out.println("Invalid Creditiantials,Please try again");
                       continue;
                   }

                   if(user.getRole()== UserRole.ADMIN){
                       Menu menu=new AdminMenu(vehicleService,userService,rentalService);
                       menu.displayMenu();
                   }else{
                       Menu menu=new CustomerMenu(vehicleService,userService,rentalService);
                       menu.displayMenu();

                   }

                } catch (Exception e) {
                    System.out.println("Error:"+e.getMessage());
                }

            } else if (option==2) {
                System.out.print("Enter new username: ");
                String newUsername = scanner.nextLine();
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                System.out.print("Enter role (ADMIN / CUSTOMER): ");
                String roleInput = scanner.nextLine().toUpperCase();

                try {
                    UserRole role = UserRole.fromString(roleInput);
                    User newUser = new UserImpl(newUsername, newPassword, role);
                    userService.registerUser(newUser);
                    System.out.println("Registration successful! You can now log in.");
                } catch (Exception e) {
                    System.out.println("Invalid role entered. Please try again.");
                }

            } else if (option==3) {
                System.out.println("Exiting system. Goodbye!");
                break;


            }else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

}
