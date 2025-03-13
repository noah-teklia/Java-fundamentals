package _02_oop_projects._04_polymorphism._01_abstractclasses._02_Library_Items;

public abstract class LibraryItems {
    private String itemID;
    private String title;

    public LibraryItems(String itemID, String title) {
        this.itemID = itemID;
        this.title = title;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void displayItemDetails();

    public abstract void borrowItem();

    public abstract void returnItem();

    @Override
    public String toString(){
        return "Item ID: "+itemID+", Title: "+title;

    }
}
