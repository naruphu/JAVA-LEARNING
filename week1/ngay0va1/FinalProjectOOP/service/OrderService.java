package service;
import repository.BookRepository;
import repository.CustomerRepository;
import repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepo;
    private CustomerRepository customerRepo;
    private BookRepository bookRepo;

    public OrderService(OrderRepository orderRepo, CustomerRepository customerRepo, BookRepository bookRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.bookRepo = bookRepo;
    }

    public void createOrder(int customerId, int bookId, int quantity) {
        Customer customer = customerRepo.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer with ID " + customerId + " not found."));
        Book book = bookRepo.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book with ID " + bookId + " not found."));

        Order order = new Order(customer, book, quantity);
        orderRepo.add(order);
        System.out.println("Order created: " + order);
    }

    public double calculateRevenue() {
        double totalRevenue = 0;
        for (Order order : orderRepo.getAll()) {
            totalRevenue += order.getBook().getPrice() * order.getQuantity();
        }
        return totalRevenue;
    }

    public List<Order> getAllOrders() {
        return orderRepo.getAll();
    }
}
