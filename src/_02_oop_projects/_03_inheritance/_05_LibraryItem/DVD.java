package _02_oop_projects._03_inheritance._05_LibraryItem;

public class DVD extends LibraryItem {
    private double duration;

    public DVD(String title, String author, double duration) {
        super(title, author);
        this.duration = duration;

    }
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Duration: "+duration);
    }
    @Override
    public String toString() {
        return super.toString()+ ", Duration= " + duration;



    }
}
