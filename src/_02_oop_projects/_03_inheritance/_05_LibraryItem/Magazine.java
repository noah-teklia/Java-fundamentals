package _02_oop_projects._03_inheritance._05_LibraryItem;

public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, String author, int issueNumber) {
       super(title,author);
       this.issueNumber=issueNumber;

    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Issue Number:"+issueNumber);

    }
    @Override
    public String toString() {
        return super.toString()+ ", Issue Number= " + issueNumber;

    }
}
