package _02_oop_projects._05_exception_handling._02_student.menu;

import _02_oop_projects._05_exception_handling._02_student.Exception.InvalidMenuOptionException;

import java.util.Scanner;

public abstract class Menu {
    Scanner scanner = new Scanner(System.in);

    public abstract void displayMenu();

    public abstract void handleOption(int option) throws InvalidMenuOptionException;

    public abstract void run() throws InvalidMenuOptionException;


}
