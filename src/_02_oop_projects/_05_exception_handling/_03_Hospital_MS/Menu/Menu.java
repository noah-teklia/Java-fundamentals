package _02_oop_projects._05_exception_handling._03_Hospital_MS.Menu;

import  _02_oop_projects._05_exception_handling._03_Hospital_MS.exceptions.InvalidMenuOptionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    protected Scanner scanner=new Scanner(System.in);
    protected abstract void displayMenu();
    protected abstract void  handleOption(int option) throws InvalidMenuOptionException, InputMismatchException;
    protected abstract void run();

}
