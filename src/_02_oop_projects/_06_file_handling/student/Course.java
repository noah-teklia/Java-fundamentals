package _02_oop_projects._06_file_handling.student;

public enum Course {
    COMPUTER_SCIENCE,
    MATHEMATICS,
    PHYSICS,
    ENGINEERING,
    MEDICINE;

    public static Course fromString(String value) {
        return Course.valueOf(value.toUpperCase());

    }


}
