package model1;
public class OrderItems{
    private Book book;
    private int quantity;

    public OrderItems(Book book, int quantity){
        if(book == null) throw new IllegalArgumentException("Book can not be null");
        this.book = book;
        if(quantity <= 0) throw new IllegalArgumentException("Quantity can not be 0");
        this.quantity = quantity;
    }

    public double calculateSubtotal(){
        double total = 0;
        total += book.getPrice() * quantity;
        return total;
    }
    public Book getBook(){
        return book;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        if(quantity <= 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return book.getTitle()
                + " | quantity: " + quantity
                + " | price: " + book.getPrice()
                + " | subtotal: " + calculateSubtotal();
    }
}