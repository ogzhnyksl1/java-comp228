package Book;

//abstract class Book that defines main fields like title, isbn, publisher, year and price
//we used abstract becouse it will be a blueprint for our child classes.

public abstract class Book {
    private String title;
    private String ISBN;
    private String publisher;
    private int year;
    protected double price;

    public Book(String title, String ISBN, String publisher, int year) {
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.year = year;
    }

//Getters for instance variables except price.

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

//abstract method to set the price >> setPrice() and to return the book genre >> getGenre()

    public abstract void setPrice(double price);

    public abstract String getGenre();

    @Override
    public String toString() {
        return "Title: " + title + "\nISBN: " + ISBN + "\nPublisher: " + publisher +
                "\nYear: " + year + "\nPrice: $" + price;
    }
}

//to display stored values above in book details