package model1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order{
    private String id;
    private Customer customer;
    private List<OrderItem> orderItems;
    private LocalDate orderDate;

    public Order(String id, Customer customer, List<OrderItem> orderItems, LocalDate orderDate) {
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("Order ID cannot be null or empty");
        }
        if(customer == null){
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if(orderItems == null || orderItems.isEmpty()){
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        if(orderDate == null){
            throw new IllegalArgumentException("Order date cannot be null");
        }
        this.id = id;
        this.customer = customer;
        this.orderItems = new ArrayList<>(orderItems);
        this.orderDate = orderDate;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(orderItems);
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void add(OrderItem orderItem) {
        if(orderItem == null) {
            throw new IllegalArgumentException("Order item cannot be null");
        }
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem) {
        if (orderItem == null) {
            throw new IllegalArgumentException("Order item cannot be null");
        }
        orderItems.remove(orderItem);
    }

    @Override
    public String toString(){
        return "Order ID: " + id + " | Customer: " + customer.getName() + " | Order Date: " + orderDate + " | Total Amount: $" + getTotalAmount();  
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + id);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Order Date: " + orderDate);
        System.out.println("Order Items:");
        for (OrderItem item : orderItems) {
            System.out.println(item);
        }
        System.out.printf("Total Amount: $%.2f", getTotalAmount());
    }

}