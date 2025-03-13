package _02_oop_projects._05_exception_handling._01_library.menu;

import java.util.Scanner;

public abstract class Menu {
    Scanner scanner = new Scanner(System.in);

    abstract void displayMenu();

    abstract void handleOption(int option);

    abstract void run();

}

