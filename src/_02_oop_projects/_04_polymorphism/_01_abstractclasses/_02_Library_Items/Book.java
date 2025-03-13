package _02_oop_projects._04_polymorphism._01_abstractclasses._02_Library_Items;

public class Book extends LibraryItems {
    String author;
    boolean isBorrowed;

    public Book(String itemID, String title, String author ) {
        super(itemID, title);
        this.author = author;

    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + author);
        System.out.println("Is Borrowed:" + isBorrowed);


    }

    @Override
    public void borrowItem() {
        if (isBorrowed) {
            System.out.println("The book is already borrowed");
        } else {
            isBorrowed = true;
            System.out.println("The book is successfully borrowed");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("The book is returned successfully");

        } else {
            System.out.println("The book is not taken.");
        }
    }

    @Override
    public String toString(){
        return super.toString()+", Author: "+author+", isBorrowed: "+isBorrowed;
    }
}
