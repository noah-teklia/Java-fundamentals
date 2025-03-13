package _02_oop_projects._01_basic._08_multiple_booklibrary;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private boolean isborrowed;

    public Book(String bookID, String title, String author, boolean isborrowed) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isborrowed = isborrowed;
    }

    public String getBookID(){
        return bookID;
    }

    private void borrowBook() {
        if (isborrowed) {
            System.out.println("Book with ID " + bookID + " is already borrowed");
        } else {
            isborrowed = true;
            System.out.println("The book with ID " + bookID + " is borrowed successfully");


        }

    }

    private void returnBook() {
        if (isborrowed) {
            isborrowed = false;
            System.out.println("Book with ID " + bookID + " is returned successfully");
        } else {
            System.out.println("Book with ID " + bookID + " is not borrowed.");
        }


    }

    public void displayDetails() {
        System.out.print("Book ID: " + bookID);
        System.out.print(", Title: " + title);
        System.out.print(", Author: " + author);
        System.out.println(", Status: " + (isborrowed ? "Available" : "Not available"));
    }
}
