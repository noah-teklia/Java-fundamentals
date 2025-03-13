package _02_oop_projects._06_file_handling.rental.model;

import _02_oop_projects._06_file_handling.rental.constants.UserRole;

public interface User {
     String getUsername();
     String getPassword();
     UserRole getRole();
}
