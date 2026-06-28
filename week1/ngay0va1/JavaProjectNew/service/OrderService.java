package service;
import exception.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model1.*;
import repository.*;

public class OrderService {
    private OrderRepository orderRepository;
    private BookRepository bookRepository;
    private CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, BookRepository bookRepository, CustomerRepository customerRepository){
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
    }

    public Order createOrder(String orderId, String customerId, Map<String, Integer> orderData){
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));

        List<OrderItem> items = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : orderData.entrySet()){
            String bookId = entry.getKey();
            int quantity = entry.getValue();

            Book book = bookRepository
                    .findById(bookId)
                    .orElseThrow(() -> new BookNotFoundException("Book not found: " + bookId));
            if(book.getQuantity() < quantity) throw new OutOfStockException(book.getTitle() + " is out of stock!");
            OrderItem item = new OrderItem(book, quantity);

            items.add(item);
            book.setQuantity(book.getQuantity() - quantity);
        }
        Order order = new Order(orderId, customer, items, LocalDate.now());
        orderRepository.add(order);
        return order;
    }

    public Order findOrderById(String id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + id));

    }

    public List<Order> getAllOrder(){
        return orderRepository.getAll();
    }

    public void removeOrder(String id){
        Order order = findOrderById(id);
        orderRepository.remove(order);
    }

    public double getOrderTotal(String orderId){
        Order order = findOrderById(orderId);
        return order.getTotalAmount();
    }





    
}