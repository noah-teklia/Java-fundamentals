package _02_oop_projects._06_file_handling.rental.menu;

import java.util.Scanner;

public interface Menu {
    Scanner scanner = new Scanner(System.in);
    void displayMenu();
    void handleUserChoice(int choice);

}
