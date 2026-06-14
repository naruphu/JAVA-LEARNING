package model1;
import java.time.LocalDate;
import java.util.*;


public class Order{
    private int orderId;
    private Customer customer;
    private List<OrderItems> books;
    private LocalDate orderDate;    

    public Order(int orderId, Customer customer, List<OrderItems> books, LocalDate orderDate){
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        if (books == null) {
            throw new IllegalArgumentException("Book list cannot be null");
        }

        if (orderDate == null) {
            throw new IllegalArgumentException("Order date cannot be null");
        }

        this.orderId = orderId;
        this.customer = customer;
        this.books = new ArrayList<>(books);
        this.orderDate = orderDate;
    }

    public int getOrderId(){
        return orderId;
    }
    public Customer getCustomer(){
        return customer;
    }
    public List<OrderItems> getBooks(){
        return Collections.unmodifiableList(books);
    }
    public LocalDate getDate(){
        return orderDate;
    }

    public double calculateTotal(){
        double total = 0;
        for(OrderItems book : books){
            total += book.calculateSubtotal();
        }
        return total;
    }

    public void addBook(Book book, int quantity) {
        if(quantity <= 0) throw new IllegalArgumentException("Quantity cannot be negative");
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        if(quantity > book.getQuantity()){
            System.out.println("Not enough books for " + book.getTitle());
            return;
        }

        for(OrderItems item : books){
            if(item.getBook().equals(book)){
                item.setQuantity(item.getQuantity() + quantity);
                book.setQuantity(book.getQuantity() - quantity);
                return;

            }
        }
        OrderItems item = new OrderItems(book, quantity);
        books.add(item);
        book.setQuantity(book.getQuantity() - quantity);
        System.out.println("ADD BOOK TO ORDER: "  + book.getTitle() + " - " + quantity);

    }

    public void removeBook(Book book) {
        if (book == null)throw new IllegalArgumentException("Book cannot be null");
        Iterator<OrderItems> iterator = books.iterator();
        while(iterator.hasNext()){
            OrderItems item = iterator.next();
            if(item.getBook().equals(book)){
                book.setQuantity(book.getQuantity() + item.getQuantity());
                iterator.remove();
                System.out.println("Remove book: " + book.getTitle());
                return;
            }
        }
    }


    public void printInvoice(){
        System.out.println("------------INVOICE-------------");
        System.out.println("OrderId = " + orderId);
        System.out.println("Customer = " + customer);
        System.out.println("OrderDate = " + orderDate );
        System.out.println("Items: ");
        if(books.isEmpty()) System.out.println("No books in this order");
        else{
            for(int i = 0; i < books.size(); i++){
                System.out.println((i + 1) + ". " + books.get(i));
    
            }
        }
        System.out.println("Total: " + calculateTotal());


    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", books=" + books +
                ", orderDate=" + orderDate +
                '}';
    }
}
