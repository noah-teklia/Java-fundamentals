package _00_fundamentals;


import java.util.Scanner;


public class _02_MovieRentalSystem {
    static Scanner scanner = new Scanner(System.in);


    static String[] usernames = new String[50];
    static String[] passwords = new String[50];
    static String[] types = new String[50];
    static int userCount = 2;

    static int passwordCount = 0;
    static int maximumPasswordCount = 3;

    static String loggedInUser = "";
    static boolean isAdmin = false;

    static String[] movieTitles = new String[10];
    static String[] movieDirectors = new String[10];
    static int[] movieStock = new int[10];
    static int movieCount = 0;


    // Arrays for borrowed books
    static String[] borrowedMovies = new String[10];
    static int borrowCount = 0;

    public static void main(String[] args) {
        System.out.println("--- Welcome to the Movie Rental System ---");


        usernames[0] = "admin1";
        passwords[0] = "admin1";
        types[0] = "admin";

        usernames[1] = "user1";
        passwords[1] = "user1";
        types[1] = "user";

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
                        userMenu();
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
        System.out.println("Login: ");
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
        System.out.println("signup: ");
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

                System.out.print("confirm password:");
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
            System.out.print("Enter User type (admin/user): ");
            String newType = scanner.nextLine();

            if (!newType.equalsIgnoreCase("admin") && (!newType.equalsIgnoreCase("user"))) {
                System.out.println("Invalid user type. Please enter 'user' or 'admin'");
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
            System.out.println("1. Add Movie");
            System.out.println("2. View All Movies");
            System.out.println("3. View Users");
            System.out.println("4. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                addMovie();

            } else if (choice == 2) {

                viewAllMovies();

            } else if (choice == 3) {

                viewUsers();


            } else if (choice == 4) {

                loggedInUser = "";
                isAdmin = false;
                System.out.println("Logout successfully ");
                break;

            } else {
                System.out.println("invalid choice . please try again");
            }


        }


    }

    public static void userMenu() {

        /*
        --- User Operations ---
        1. View Available Movies
        2. Rent a Movie
        3. View Rented Movies
        4. Return a Movie
        5. Logout
        Enter your choice:
         */
        while (true) {
            System.out.println("------------User Operations-----------");
            System.out.println("1. View Available Movies");
            System.out.println(" 2. Rent a Movie");
            System.out.println(" 3. View Rented Movies");
            System.out.println("4. Return a Movie");
            System.out.println("5. Logout");

            System.out.print(" Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                viewAvailableMovies();

            } else if (choice == 2) {

                rentMovie();

            } else if (choice == 3) {

                viewRentedMovies();

            } else if (choice == 4) {

                returnMovie();

            } else if (choice == 5) {

                loggedInUser = "";
                System.out.println("Logged out successfully");
                break;

            } else {
                System.out.println("invalid choice");

            }
        }
    }

    private static void addMovie() {
        if (movieCount < movieTitles.length) {

            System.out.print("Enter movie title: ");
            String movieTitle = scanner.nextLine();

            System.out.println("Enter movie Director: ");
            String movieDirector = scanner.nextLine();

            System.out.println("Enter stock quantity");
            int stock = scanner.nextInt();
            scanner.nextLine();

            movieTitles[movieCount] = movieTitle;
            movieDirectors[movieCount] = movieDirector;
            movieStock[movieCount] = stock;
            movieCount++;
            System.out.println("Movie added successfully ");
        } else {
            System.out.println("Movie list is currently full");
        }


    }

    private static void viewAllMovies() {
        if (movieCount == 0) {
            System.out.println("No Movie available to rent");
        } else {
            System.out.println("\n----Movie list-----");
            for (int i = 0; i < movieCount; i++) {
                System.out.println((i + 1) + "." + movieTitles[i] + "by" + movieDirectors[i] + "(stock:" + movieStock[i] + ")");

            }
        }
    }

    private static void viewUsers() {
        System.out.println("\n----users list----");
        for (int i = 0; i < userCount; i++) {
            System.out.println((i + 1) + ".username:" + usernames[i] + "-Types" + types[i]);

        }

    }

    private static void rentMovie() {
        System.out.println("Enter movie index to rent(1 to " + movieCount + "):");
        int movieIndex = scanner.nextInt() - 1;
        if (movieIndex >= 0 && movieIndex < movieCount) {
            if (movieStock[movieIndex] > 0) {
                borrowedMovies[borrowCount] = movieTitles[movieIndex];
                borrowCount++;
                movieStock[movieIndex]--;
                System.out.println("You rent:" + movieTitles[movieIndex]);
            } else {
                System.out.println("movie is out of stock");
            }


        } else {
            System.out.println("Invalid index.");
        }


    }

    private static void returnMovie() {
        if (borrowCount == 0) {
            System.out.println("you have no movie to return");
        } else {
            System.out.println("\n--- return a Movie-----");
            for(int i=0; i<borrowCount;i++){
                System.out.println((i+1) + "." + "Movie Titles : " + borrowedMovies[i] );

            }
            System.out.print(" Enter movie index: ");
            int index= scanner.nextInt()-1;

            if( index >= 0 && index < borrowCount){

                String returnMovieTitle= borrowedMovies[index];

                for(int i=0; i<movieCount; i++){
                    if(movieTitles[i].equalsIgnoreCase(returnMovieTitle)){
                        movieStock[i]++;
                        break;
                    }
                }

                for(int i=index; i<borrowCount-1 ; i++){
                    borrowedMovies[i]=borrowedMovies[i+1];

                }
                borrowCount--;
                System.out.println("Movie returned" + returnMovieTitle);




            }else{
                System.out.println("Invalid Index ");
            }


        }
    }

    private static void viewAvailableMovies(){
        if(movieCount==0){
            System.out.println("There is no available movie to rent");
        }
        else{
            System.out.println("\n----List of movies---");
            for(int i=0;i<movieCount;i++){
                System.out.println((i+1) + "." + "Movie Title" + movieTitles[i] + " Stock: " + movieStock[i]);
            }
        }
    }

    private static void viewRentedMovies(){
        if(borrowCount == 0){
            System.out.println("There is no rented movie");
        } else{
            for (int i=0;i<borrowCount;i++){
                System.out.println("(i+1)" + "." + "RentedMovies: " + borrowedMovies[i]);
            }
        }
    }
}


