package _02_oop_projects._05_exception_handling._01_library.model;

public abstract class LibraryItem {
    private String itemID;
    private String title;
    private boolean isBorrowed;
    private String borrowedBy;

    public abstract void displayItemDetails();

    public LibraryItem(String itemID, String title, boolean isBorrowed, String borrowedBy) {
        this.itemID = itemID;
        this.title = title;
        this.isBorrowed = isBorrowed;
        this.borrowedBy = borrowedBy;

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

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }



    public void borrowItem(String userID) throws Exception {
        if (isBorrowed) {
            throw new Exception("Item is already borrowed by user ID: " + borrowedBy);

        }

        isBorrowed = true;
        borrowedBy = userID;

        System.out.println("Item is borrowed successfully by user ID:  " + userID);


    }

    public void returnItem() throws Exception {
        if (!isBorrowed) {
            throw new Exception("Item is not borrowed by any user");

        }

        isBorrowed = false;
        borrowedBy = null;

        System.out.println("Item is returned successfully");


    }
}
