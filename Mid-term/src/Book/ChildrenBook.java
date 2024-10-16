package Book;

//We are going from general to specific type of book, a child book for this child class.

public class ChildrenBook extends Book {
    public ChildrenBook(String title, String ISBN, String publisher, int year) {
        super(title, ISBN, publisher, year);
    }
    //I call the parent class constructor which allows me to pass inital values to children's book other than price

//we override the ToString method in bookdriverclass
    @Override
    public void setPrice(double price) {
        this.price = 4.99;
    }
//setter for price

    @Override
    public String getGenre() {
        return "Children";
    }
}
