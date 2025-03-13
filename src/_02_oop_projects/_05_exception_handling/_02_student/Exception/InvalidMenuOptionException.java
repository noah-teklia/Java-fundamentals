package _02_oop_projects._05_exception_handling._02_student.Exception;

public class InvalidMenuOptionException extends Exception {
    public InvalidMenuOptionException(String message) {
        super(message);
    }
}
