package file;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model1.*;
public class OrderFileManager{
    private static final String FILE_PATH = "storage/orders.txt";
    private BookFileManager bookFileManager;
    private CustomerFileManager customerFileManager;

    public OrderFileManager(){
        this.bookFileManager = new BookFileManager();
        this.customerFileManager = new CustomerFileManager();
    }

    public void saveOrdersToFile(List<Order> orders){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));
            for(Order order : orders){
                for(OrderItem item : order.getItems()){
                    bw.write(
                        order.getId() + ", " +
                        order.getCustomer().getId() + ", " +
                        item.getBook().getId() + ", " +
                        item.getQuantity() + ", " +
                        order.getTotalAmount()
                    );
                }
            }
            bw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Order> loadOrdersFromFile(){
        List<Order> orders = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                System.out.println("Line: " + line);
                System.out.println("Parts length: " + parts.length);
                if(parts.length == 5){
                    String id = parts[0].trim();
                    String id2 = parts[1].trim();
                    String id3 = parts[2].trim();
                    int quantity = Integer.parseInt(parts[3].trim());
                    double total = Double.parseDouble(parts[4].trim());

                    Customer customers = customerFileManager.loadCustomer()
                            .stream()
                            .filter(c -> c.getId().equals(id2))
                            .findFirst()
                            .orElse(null);
                    Book books = bookFileManager.loadBooksFromFile()
                            .stream()
                            .filter(b -> b.getId().equals(id3))
                            .findFirst()
                            .orElse(null);
                    
                    if(customers != null && books != null){
                        List<OrderItem> items = new ArrayList<>();
                        items.add(new OrderItem(books, quantity));
                        orders.add(new Order(id, customers, items, LocalDate.now() ));
                    }
                    System.out.println("Customer found: " + (customers != null));
                    System.out.println("Book found: " + (books != null));

                }
            }
            
        } catch (Exception e) {
        }
        return orders;
    }
}