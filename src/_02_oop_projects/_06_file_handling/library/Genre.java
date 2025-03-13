package _02_oop_projects._06_file_handling.library;

public enum Genre {
    FICTION,
    NON_FICTION,
    SCIENCE,
    HISTORY,
    TECHNOLOGY;

    public static Genre fromString(String value) {
        return Genre.valueOf(value.toUpperCase());
    }
}
