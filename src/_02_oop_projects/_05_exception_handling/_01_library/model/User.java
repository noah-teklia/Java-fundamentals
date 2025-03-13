package _02_oop_projects._05_exception_handling._01_library.model;

public class User {
    private String userID;
    private String name;
    private int borrowedItemCount;

    public User(String userID, String name, int borrowedItemCount) {
        this.userID = userID;
        this.name = name;
        this.borrowedItemCount = borrowedItemCount;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBorrowedItemCount() {
        return borrowedItemCount;
    }

    public void setBorrowedItemCount(int borrowedItemCount) {
        this.borrowedItemCount = borrowedItemCount;
    }

    public void displayUserDetails() {
        System.out.println("User ID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Borrowed Items Count: " + borrowedItemCount);


    }
    @Override
    public String toString(){
        return "User ID: " + userID+", Name: " + name+", Borrowed Items Count: " + borrowedItemCount;
    }
}

