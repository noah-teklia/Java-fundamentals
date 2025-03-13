package _02_oop_projects._05_exception_handling._01_library.model;

public class Book extends LibraryItem {
    private String author;

    public Book(String itemID, String title, boolean isBorrowed, String borrowedBy, String author) {
        super(itemID, title, isBorrowed, borrowedBy);
        this.author = author;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + author);
        System.out.println("Status: " + (isBorrowed() ? "Yes" : "No"));
        System.out.println("Borrowed By: " + getBorrowedBy());


    }

    @Override
    public String toString() {
        return "Item ID: " + getItemID() + ", Title: " + getTitle() + ", Author: " +
                author + ", Status: " + (isBorrowed() ? "Yes" : "No") + ", Borrowed By: " + getBorrowedBy();
    }
}
