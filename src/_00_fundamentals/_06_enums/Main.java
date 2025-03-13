package _00_fundamentals._06_enums;

import java.security.PublicKey;

enum Role {
    ADMIN("admin"),
    USER("user");

    private final String type;

    Role(String type) {
        this.type = type;

    }

    public String getType() {
        return type;


    }


}
public class Main {
    public static void main(String[] args) {
        Role role= Role.ADMIN;
        System.out.println("Role: "+role);
        System.out.println("Type: "+role.getType());

        System.out.println(Role.valueOf("admin".toUpperCase()));
    }

}
