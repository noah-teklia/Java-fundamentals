package _02_oop_projects._06_file_handling.rental.model;

import _02_oop_projects._06_file_handling.rental.constants.UserRole;

public class UserImpl implements User {

    private String username;
    private String password;
    private UserRole userRole;

    public UserImpl(String username, String password, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public UserRole getRole() {
        return userRole;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
