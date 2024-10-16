package Book;

//and for this one its ScienceBook. which has initial title, isbn, publsh and year values.

public class ScienceBook extends Book {
    public ScienceBook(String title, String ISBN, String publisher, int year) {
        super(title, ISBN, publisher, year);
    }

    @Override
    public void setPrice(double price) {
        super.price = price * 0.9;
    }
    //setter for price
    //we set the price here using the super value's %90.

    @Override
    public String getGenre() {
        return "Science";
    }
}
