package _01_oop._01_classdesign;

public class BookRunner {
    public static void main(String[] args) {
        Book book1= new Book();
        book1.title="Water fall";
        book1.author="Robert";
        book1.yearPublished=1963;
        book1.getDetails();

        Book book2= new Book();
        book2.title="RunAway Jury";
        book2.author="John Grisham";
        book2.yearPublished=2000;
        book2.getDetails();

        Book book3= new Book();
        book3.title="Bible";
        book3.author="Jesus Christ";
        book3.yearPublished=1;
        book3.getDetails();



        System.out.println("***********************");

       /* int[] numbers = new int[2];
        numbers[0]=1;
        numbers[1]=2;
        for (int i = 0; i <numbers.length ; i++) {
            System.out.println(numbers[i]);

        }

        */
        Book[] books= new Book[3];
        books[0]=book1;
        books[1]=book2;
        books[2]=book3;

        for (int i = 0; i <books.length; i++) {
            books[i].getDetails();
            System.out.println();


        }
        System.out.println("************");

        for(Book book : books){
            book.getDetails();
            System.out.println();
        }

    }



}
