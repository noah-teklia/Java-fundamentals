package _02_oop_projects._06_file_handling.rental.service;

import _02_oop_projects._06_file_handling.rental.model.User;

import java.io.IOException;

public interface UserService {
    void registerUser(User user) throws IOException;

    User authenticateUser(String username, String password) throws IOException;

    User getUserByUsername(String username) throws IOException;

}
