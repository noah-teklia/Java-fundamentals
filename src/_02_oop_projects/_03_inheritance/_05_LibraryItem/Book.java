package _02_oop_projects._03_inheritance._05_LibraryItem;

public class Book extends LibraryItem {
    private String genre;

    public Book(String title, String author, String genre) {
        super(title, author);
        this.genre = genre;

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Genre: "+ genre);
    }

    @Override
    public String toString() {
        return super.toString()+ ", Genre= " + genre;

    }
}
