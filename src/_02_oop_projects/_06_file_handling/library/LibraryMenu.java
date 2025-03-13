package _02_oop_projects._06_file_handling.library;

import _02_oop_projects._06_file_handling.student.Course;

import java.io.IOException;
import java.util.List;


public class LibraryMenu extends Menu {
    List<String> MENU_OPTIONS = List.of("Add books", "Display books", "Update book information", "Delete a book", " Exit");

    LibraryService libraryService = new LibraryServiceImpl();

    @Override
    void displayMenu() {
        while (true) {
            for (int i = 0; i < MENU_OPTIONS.size(); i++) {
                System.out.println((i + 1) + ". " + MENU_OPTIONS.get(i));

            }
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            if (choice == 5) {
                System.out.println("Exiting the program");
                break;
            }
            try {
                handleChoice(choice);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    public void handleChoice(int choice) throws IOException, BookNotFoundException {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                getAllBooks();
                break;
            case 3:
                updateBook();
                break;
            case 4:
                deleteBook();
                break;

            default:
                System.out.println("Invalid choice. Please try valid input");


        }

    }

    private void deleteBook() throws IOException, BookNotFoundException {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();

        libraryService.deleteBook(id);
        System.out.println("Book with ID " + id + " deleted successfully");

    }

    private void updateBook() throws IOException, BookNotFoundException {
        System.out.print("Enter Book ID: ");
        int bookID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Title: ");
        String newTitle = scanner.nextLine();

        System.out.print("Enter New Author: ");
        String newAuthor = scanner.nextLine();

        System.out.println("Genre List: ");

        for (Genre value : Genre.values()) {
            System.out.println(" " + value);

        }

        System.out.print("Enter New Genre Name: ");
        String strNewGenre = scanner.nextLine();
        Genre newGenre = Genre.fromString(strNewGenre);


        System.out.print("Enter New Available Copies: ");
        int newAvailableCopies = scanner.nextInt();

        libraryService.updateBook(bookID, newTitle, newAuthor, newGenre, newAvailableCopies);
        System.out.println("Book with ID " + bookID + " updated successfully");


    }

    private void getAllBooks() throws IOException {

        List<Book> books = libraryService.getAllBooks();

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));

        }
    }

    private void addBook() throws IOException {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        System.out.println("Genre List: ");


        Genre genre = null;


        while (true) {
            for (Genre value : Genre.values()) {
                System.out.println(" " + value);

            }

            System.out.print("Enter Genre Name: ");
            String strGenre = scanner.nextLine();
            try {
                genre = Genre.fromString(strGenre);
                break;
            } catch (Exception e) {
                System.out.println("You selected invalid choice,please select a valid course name");
            }


        }
        System.out.print("Enter Available Copies: ");
        int availbleCopies = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(id, title, author, genre, availbleCopies);
        libraryService.addBook(book);
        System.out.println("Book added successfully");


    }
}
