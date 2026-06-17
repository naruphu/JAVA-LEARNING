import file.BookFileManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model1.*;
import repository.BookRepository;
import repository.Repository;
import file.CustomerFileManager;
import file.OrderFileManager;


class Main{
    public static void main(String[] args) {
        Book java = new Book(001, "Java Core", "Phu Nguyen", 50.5, 20, Category.TECHNOLOGY);
        Book c = new Book(002, "C++ Core", "Phu Nguyen", 100, 20, Category.TECHNOLOGY);
        Book python = new Book(003, "Python Core", "Phu Nguyen", 200, 20, Category.TECHNOLOGY);

        Customer c1 = new Customer(100, "Kiet", "abc@gmail.com", "GOLD");

        List<OrderItems> items = new ArrayList<>();
        Order order = new Order(1, c1, items, LocalDate.now());
        System.out.println("-------------------TEST ADD----------------------");
        order.addBook(java, 2);
        order.addBook(c, 5);

        System.out.println("Java stock: " + java.getQuantity());
        System.out.println("C book: " + c.getQuantity());
        System.out.println("Total: " + order.calculateTotal());
        order.printInvoice();

        Repository<Book> bookRepository = new Repository<>();
        bookRepository.add(java);
        bookRepository.add(c);
        bookRepository.add(python);
        System.out.println("-------------------TEST REPOSITORY----------------------");
        System.out.println("Books in repository:");         
        for (Book book : bookRepository.getAll()) {
            System.out.println(book.getTitle());
        }
        System.out.println(bookRepository.size());
        bookRepository.remove(c);
        System.out.println("Books in repository after removal:");   
        for (Book book : bookRepository.getAll()) {
            System.out.println(book.getTitle());
        }
        System.out.println(bookRepository.size());

        BookRepository bookRepo = new BookRepository();
        bookRepo.add(java); 
        bookRepo.add(c);
        bookRepo.add(python);
        System.out.println("-------------------TEST SEARCHABLE----------------------");
        List<Book> searchResults = bookRepo.search("core");
        System.out.println("Search results for 'core':");
        for (Book book : searchResults) {
            System.out.println(book.getTitle());
        }

        bookRepo.findById(002).ifPresent(book -> System.out.println("Found book: " + book.getTitle()));
        System.out.println("Book with ID 002 exists: " + bookRepo.existsById(002));
        System.out.println("Book with ID 999 exists: " + bookRepo.existsById(999));


        BookFileManager fileManager = new BookFileManager();
        List<Book> booksToSave = new ArrayList<>();
        booksToSave.add(java);
        booksToSave.add(c);
        booksToSave.add(python);
        fileManager.saveBooksToFile(booksToSave);
        List<Book> loadedBooks = fileManager.loadBooksFromFile();
        System.out.println("Loaded books from file:");
        for (Book book : loadedBooks) {
            System.out.println(book.getTitle());
        }

        CustomerFileManager customerFileManager = new CustomerFileManager();
        List<Customer> customersToSave = new ArrayList<>();
        customersToSave.add(c1);
        customerFileManager.saveCustomersToFile(customersToSave);
        List<Customer> loadedCustomers = customerFileManager.loadCustomersFromFile();
        System.out.println("Loaded customers from file:");
        for (Customer customer : loadedCustomers) {
            System.out.println(customer.getName());
        }

        OrderFileManager orderFileManager = new OrderFileManager();
        List<Order> ordersToSave = new ArrayList<>();       
        ordersToSave.add(order);
        orderFileManager.saveOrdersToFile(ordersToSave);    
        List<Order> loadedOrders = orderFileManager.loadOrdersFromFile();
        System.out.println("Loaded orders from file:");
        for (Order loadedOrder : loadedOrders) {
            System.out.println("Order ID: " + loadedOrder.getId() + ", Customer: " + loadedOrder.getCustomer().getName() + ", Total: " + loadedOrder.calculateTotal());
        }

    }
}