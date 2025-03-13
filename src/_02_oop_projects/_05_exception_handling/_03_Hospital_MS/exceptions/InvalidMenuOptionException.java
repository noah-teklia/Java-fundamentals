package _02_oop_projects._05_exception_handling._03_Hospital_MS.exceptions;

public class InvalidMenuOptionException extends Exception {
    public InvalidMenuOptionException(String message) {
        super(message);
    }
}
