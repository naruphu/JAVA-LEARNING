package model1;
import exception.*;
public class Book{
    private int id;
    private String title;
    private String author;
    private double price;
    private int quantity;
    private Category category;

    public Book(int id, String title, String author, double price, int quantity, Category category){
        this.id = id;
        if(title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title can not be empty");
        this.title = title;
        if(author == null || author.trim().isEmpty()) throw new IllegalArgumentException("Title can not be empty");
        this.author = author;
        setPrice(price);
        setQuantity(quantity);
        if(category == null) throw new IllegalArgumentException("Category can not be empty");
        this.category = category;
    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        if(price <= 0) throw new InvalidPriceException("Price cannot be zero or negative");
        this.price = price;
    }   
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        if(quantity < 0) throw new OutOfStockException("Quantity cannot be negative");
        this.quantity = quantity;
    }
    public Category getCategory(){
        return category;
    }
    public void setCagegory(Category category){
        this.category = category;
    }

    @Override
    public String toString() {
    return "Book{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", price=" + price +
            ", quantity=" + quantity +
            ", category=" + category +
            '}';
    }
}




