package _01_oop._01_classdesign;

public class Book {
    /*
    Library System
Objective: Model books in a library.

Requirements:

Create a Book class with attributes: title, author, and yearPublished.
Add a method getDetails() to print the book’s details.
     */
    public String title;
    public String author;
    public int yearPublished;

    public void getDetails(){
        System.out.println("Title: "+ title );
        System.out.println("Author: "+ author);
        System.out.println("Year Published: "+yearPublished);

    }
}
