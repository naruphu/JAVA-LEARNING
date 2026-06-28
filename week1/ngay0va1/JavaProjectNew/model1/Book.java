package model1;
public class Book{
    private String id;
    private String title;
    private String author;
    private double price;
    private int quantity;
    private Category category;

    public Book(String id, String title, String author, double price, int quantity, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        setPrice(price);
        setQuantity(quantity);
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }
    @Override
    public String toString(){
        return id + " - " + title + " by " + author + " | Price: $" + price + " | Quantity: " + quantity + " | Category: " + category;  
    }


}