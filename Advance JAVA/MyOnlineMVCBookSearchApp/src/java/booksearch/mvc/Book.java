
package booksearch.mvc;

public class Book {

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookname() {
        return bookname;
    }

    public double getPrice() {
        return price;
    }
    private String bookname;
    private double price;
    
}
