package _02_oop_projects._01_basic._02_bookLibrary;

public class LibraryBook {
    private String bookID;
    private String title;
    private String author;
    private boolean isBorrowed;

    public LibraryBook(String bookID, String title, String author, boolean isBorrowed) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }
    public void borrowBook(){
        if(isBorrowed){
            System.out.println("Sorry. The book is not available");
        }else{
            isBorrowed=true;
            System.out.println("You have successfully borrowed the book");
        }

    }
    public void returnBook(){
        if(isBorrowed){
            System.out.println("The book is returned successfully");
            isBorrowed=false;
        }else{
            System.out.println("The book is not borrowed");
        }

    }
    public void displayDetails(){
        System.out.println("Book details");
        System.out.println("Book ID: "+bookID);
        System.out.println("Book Title: "+title);
        System.out.println("Book Author: "+author);
        System.out.println("Book is Borrowed: "+isBorrowed);

    }
}
