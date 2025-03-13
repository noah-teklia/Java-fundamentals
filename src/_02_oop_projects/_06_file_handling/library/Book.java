package _02_oop_projects._06_file_handling.library;

public class Book implements Item {
    //id, title, author, genre, availableCopies.
    private int id;
    private String title;
    private String author;
    private Genre genre;
    private int availableCopies;

    public Book(int id, String title, String author, Genre genre, int availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availableCopies = availableCopies;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies){
        this.availableCopies = availableCopies;
    }

    @Override
    public String getTitle() {
        return title;

    }

    @Override
    public int getId() {
        return id;

    }

    @Override
    public String toString() {
        return id + "," + title + "," + author + "," + genre + "," + availableCopies;

    }

    public static Book fromString(String line) {

        String[] lineArray = line.split(",");

        int id = Integer.parseInt(lineArray[0]);
        String title = lineArray[1];
        String author = lineArray[2];
        Genre genre1 = Genre.fromString(lineArray[3]);
        int availableCopies = Integer.parseInt(lineArray[4]);


        Book book = new Book(id, title, author, genre1, availableCopies);
        return book;


    }
}
