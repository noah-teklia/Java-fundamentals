package _02_oop_projects._04_polymorphism._01_abstractclasses._02_Library_Items;

public class DVD extends LibraryItems {
    String director;
    boolean isBorrowed;

    public DVD(String itemID, String title, String director) {
        super(itemID, title);
        this.director = director;

    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Title: " + getTitle());
        System.out.println("Director: " + director);
        System.out.println("IS Borrowed: " + isBorrowed);
    }

    @Override
    public void borrowItem() {
        if (isBorrowed) {
            System.out.println("Sorry.The DVD is already borrowed");
        } else {
            isBorrowed = true;
            System.out.println("You have successfully borrowed the DVD");
        }

    }

    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("You have successfully returned the DVD ");
        } else {
            System.out.println("The DVD is not borrowed");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Director: " + director + ", isBorrowed: " + isBorrowed;
    }


}


