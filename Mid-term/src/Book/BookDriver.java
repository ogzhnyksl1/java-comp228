package Book;

import javax.swing.JOptionPane;

//BookDriver is taking user inputs through JOptionPane and also displaying it.

public class BookDriver {
    public static void main(String[] args) {
        String type = JOptionPane.showInputDialog("Enter book type (Science/Children): ");
        String title = JOptionPane.showInputDialog("Enter the book title: ");
        String ISBN = JOptionPane.showInputDialog("Enter the ISBN: ");
        String publisher = JOptionPane.showInputDialog("Enter the publisher: ");
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the publication year: "));
        double price = Double.parseDouble(JOptionPane.showInputDialog(
                "<html>----Mid-term by Oguzhan Yuksel---- <br>" +
                        "Enter the price:<br>" +
                        "(Already has a $4.99 fixed price for Children book)<br>" +
                        "For Science book, you get a 10% discount! :)</html>"
        ));

//Parse used because java gives all string.

        Book book;

        if (type.equalsIgnoreCase("Science")) {
            book = new ScienceBook(title, ISBN, publisher, year);
            book.setPrice(price);
        } else {
            book = new ChildrenBook(title, ISBN, publisher, year);
            book.setPrice(price);
        }
//If its not science book than its childrens book

        JOptionPane.showMessageDialog(null, "Book Information:\n" + book.toString() +
                "\nGenre: " + book.getGenre());
    }
}
//to give book info to the user from the inputs.
