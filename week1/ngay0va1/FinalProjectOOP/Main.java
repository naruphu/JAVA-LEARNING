import model1.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

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


    }
}