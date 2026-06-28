import file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model1.*;
import repository.*;
import service.*;
public class Main{
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();

        BookService bookService = new BookService(bookRepository);
        CustomerService customerService = new CustomerService(customerRepository);
        OrderService orderService = new OrderService(orderRepository, bookRepository, customerRepository);

        // TEST BOOK FILE
        BookFileManager bookFileManager = new BookFileManager();
        List<Book> bookToSave = new ArrayList();
        bookToSave.add(new Book("A01", "NHA GIA KIM", "NGUYEN VAN TEO", 100, 10, Category.HISTORY));
        bookFileManager.saveBooksToFile(bookToSave); 
        List<Book> loadBooks = bookFileManager.loadBooksFromFile();
        System.out.println("Loaded books from file: ");
        for(Book book : loadBooks){
            System.out.println(book.getTitle());
        }

        // TEST CUSTOMER FILE
        CustomerFileManager customerFileManager = new CustomerFileManager();
        List<Customer> customersToSave = new ArrayList<>();
        customersToSave.add(new Customer("524h0179", "Phu", "524h0179@student.tdtu.edu.vn", "123344"));
        customerFileManager.saveCustomersToFile(customersToSave);
        List<Customer> loadCustomers = customerFileManager.loadCustomer();
        System.out.println("Loaded customers from file: ");
        for(Customer customer : loadCustomers){
            System.out.println(customer.getName());
        }

        // TEST ORDER FILE

        Book b1 = new Book("A01", "NHA GIA KIM", "NGUYEN VAN TEO", 100, 10, Category.HISTORY);
        bookService.addBook(b1);
        bookService.addBook(new model1.Book("A02", "JAVA", "NGUYEN VAN TI", 150, 20, Category.TECHNOLOGY));
        Customer c1 = new Customer("524h0179", "Phu", "524h0179@student.tdtu.edu.vn", "123344");
        customerService.addCustomer2(c1);


        OrderFileManager orderFileManager = new OrderFileManager();
        List<Order> ordersToSave = new ArrayList<>();
        // List<OrderItem> item = new ArrayList<>();
        // Book b1 = new Book("B01", "And there no ones", "abac", 275, 10, Category.NON_FICTION);
        // item.add(new OrderItem(b1, 2));
        Map<String, Integer> map = new HashMap<>();
        map.put("A01", 2);
        // System.out.println("Book exists A01: " + bookService.existById("A01"));
        // System.out.println("Customer exists 524h111: " + customerService.existById("524h111"));
        // System.out.println("Map size: " + map.size());
        Order order = orderService.createOrder("001", "524h0179", map);
        ordersToSave.add(order);
        orderFileManager.saveOrdersToFile(ordersToSave);
        List<Order> loadOrders = orderFileManager.loadOrdersFromFile();

        // FIX BUG
        System.out.println("Loaded orders size: " + loadOrders.size());

        System.out.println("Loaded orders from file: ");
        for(Order orders : loadOrders){
            System.out.println(orders.getId());
        }


    }
}