package _02_oop_projects._06_file_handling.library;

import _02_oop_projects._06_file_handling.student.Menu;
import _02_oop_projects._06_file_handling.student.StudentMenu;

public class BookApp {

    static LibraryMenu menu = new LibraryMenu();

    public static void main(String[] args) {
        System.out.println("************************************");
        System.out.println("WELCOME TO BOOK MANAGEMENT SYSTEM");
        System.out.println("************************************");

        menu.displayMenu();
    }
}
