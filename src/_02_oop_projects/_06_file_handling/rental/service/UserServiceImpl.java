package _02_oop_projects._06_file_handling.rental.service;

import _02_oop_projects._06_file_handling.rental.model.User;
import _02_oop_projects._06_file_handling.rental.model.UserImpl;
import _02_oop_projects._06_file_handling.rental.constants.UserRole;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static final Path USER_PATH = Paths.get("user.txt");

    @Override
    public void registerUser(User user) throws IOException {

        Files.write(USER_PATH,(user.getUsername()+","+user.getPassword()+","+user.getRole()+"\n").getBytes(),
                StandardOpenOption.APPEND,StandardOpenOption.CREATE);
    }

    @Override
    public User authenticateUser(String username, String password) throws IOException {
        List<String> lines= Files.readAllLines(USER_PATH);
        for(String line:lines){
            String[] lineArray= line.split(",");
            if(lineArray[0].equals(username) && lineArray[1].equals(password)){
                return new UserImpl(lineArray[0],lineArray[1], UserRole.fromString(lineArray[2]));
            }
        }
        return null;

    }

    @Override
    public User getUserByUsername(String username) throws IOException {
        List<String> lines= Files.readAllLines(USER_PATH);
        for(String line:lines){
            String[] lineArray= line.split(",");
            if(lineArray[0].equals(username)){
                return new UserImpl(lineArray[0],lineArray[1],UserRole.fromString(lineArray[2]));
            }
        }
        return null;

    }
}
