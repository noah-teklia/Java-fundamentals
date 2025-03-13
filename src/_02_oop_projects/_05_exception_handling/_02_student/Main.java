package _02_oop_projects._05_exception_handling._02_student;

import _02_oop_projects._05_exception_handling._02_student.Exception.InvalidMenuOptionException;
import _02_oop_projects._05_exception_handling._02_student.menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu=new MainMenu();
        try {
            mainMenu.run();
        } catch (InvalidMenuOptionException e) {

            System.out.println(e.getMessage());
        }

    }

}
