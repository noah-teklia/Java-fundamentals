package _02_oop_projects._05_exception_handling._01_library;

import _02_oop_projects._05_exception_handling._01_library.menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        MainMenu mainMenu = new MainMenu(system);


        // mainMenu.displayMenu();
        //System.out.println("Choose an option: ");
        //int choice = mainMenu.scanner.nextInt();

        //mainMenu.scanner.nextLine();

        // mainMenu.handleOption(choice);

        mainMenu.run();

    }
}
