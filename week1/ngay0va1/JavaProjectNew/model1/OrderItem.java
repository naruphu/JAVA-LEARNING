package model1;
public class OrderItem{
    private Book book;
    private int quantity;

    public OrderItem(Book book, int quantity) {
        if(book == null){
            throw new IllegalArgumentException("Book cannot be null");
        }       
        this.book = book;
        setQuantity(quantity);
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public double getSubtotal(){
        return book.getPrice() * quantity;
    }

    @Override
    public String toString(){
        return book.toString() + " | Ordered Quantity: " + quantity;  
    }


}