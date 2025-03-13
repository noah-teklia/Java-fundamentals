package _02_oop_projects._02_encapsulation._08_multiple_booklibrary;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private boolean isBorrowed;


    public Book(String bookID, String title, String author, boolean isBorrowed) {
        this.setBookID(bookID);
        this.setTitle(title);
        this.setAuthor(author);
        this.isBorrowed = isBorrowed;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    private void borrowBook() {
        if (isBorrowed) {
            System.out.println("Book with ID " + bookID + " is already borrowed");
        } else {
            isBorrowed = true;
            System.out.println("The book with ID " + bookID + " is borrowed successfully");


        }

    }

    private void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Book with ID " + bookID + " is returned successfully");
        } else {
            System.out.println("Book with ID " + bookID + " is not borrowed.");
        }


    }

    public void displayDetails() {
        System.out.print("Book ID: " + bookID);
        System.out.print(", Title: " + title);
        System.out.print(", Author: " + author);
        System.out.println(", Status: " + (isBorrowed ? "Available" : "Not available"));
    }
}
