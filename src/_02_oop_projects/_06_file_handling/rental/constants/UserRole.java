package _02_oop_projects._06_file_handling.rental.constants;

public enum UserRole {
    ADMIN,
    CUSTOMER;

    public static UserRole fromString(String value){
        return UserRole.valueOf(value.toUpperCase());
        // return value.equalsIgnoreCase("admin") ? ADMIN : CUSTOMER;



    }
}
