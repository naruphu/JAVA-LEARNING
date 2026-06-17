package file;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model1.Book;
import model1.Customer;
import model1.Order;


public class OrderFileManager {
    // This class is currently empty and serves as a placeholder for future implementation.
    private static final String FILE_PATH = "storage/orders.txt";

    private BookFileManager bookFileManager;
    private CustomerFileManager customerFileManager;    

    public OrderFileManager() {
        this.bookFileManager = new BookFileManager();
        this.customerFileManager = new CustomerFileManager();
    }

    public void saveOrdersToFile(List<Order> orders) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Order order : orders) {
                writer.write(
                            order.getId() + "," +
                            order.getCustomer().getId() + "," +
                            order.getBook().getId() + "," +
                            order.getQuantity() + "," +
                            order.getTotalPrice()
                            );
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public List<Order> loadOrdersFromFile() {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 5) {

                    int id = Integer.parseInt(parts[0].trim());
                    int customerId = Integer.parseInt(parts[1].trim());
                    int bookId = Integer.parseInt(parts[2].trim());
                    int quantity = Integer.parseInt(parts[3].trim());
                    double totalPrice = Double.parseDouble(parts[4].trim());

                    Customer customer = customerFileManager.loadCustomersFromFile()
                        .stream()
                        .filter(c -> c.getId() == customerId)
                        .findFirst()
                        .orElse(null);

                    Book book = bookFileManager.loadBooksFromFile()
                        .stream()
                        .filter(b -> b.getId() == bookId)
                        .findFirst()
                        .orElse(null);

                    if (customer != null && book != null) {
                        orders.add(new Order(id, customer, book, quantity, totalPrice));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }
}