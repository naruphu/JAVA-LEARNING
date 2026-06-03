import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("P001", "Ao thun", 150000, 20);
        Product p2 = new Product("P002", "Quan jean", 300000, 10);
        Product p3 = new Product("P003", "Giay sneaker", 800000, 5);

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);

        Customer customer1 = new Customer("C001", "Nguyen Van An", "0909123456", "Ho Chi Minh");

        System.out.println("===== PRODUCT LIST BEFORE ORDER =====");
        for (Product product : products) {
            product.printInfo();
        }

        System.out.println();

        Order order1 = new Order("O001", customer1);

        order1.addItem(p1, 2);
        order1.addItem(p2, 1);

        System.out.println();
        System.out.println("===== INVOICE BEFORE CHECKOUT =====");
        order1.printInvoice();

        System.out.println();
        System.out.println("===== CHECKOUT BY CASH =====");
        PaymentMethod cashPayment = new CashPayment();
        order1.checkout(cashPayment);

        System.out.println();
        System.out.println("===== INVOICE AFTER CHECKOUT =====");
        order1.printInvoice();

        System.out.println();
        System.out.println("===== PRODUCT LIST AFTER ORDER =====");
        for (Product product : products) {
            product.printInfo();
        }

        System.out.println();
        System.out.println("===== TRY ADD ITEM TO PAID ORDER =====");
        order1.addItem(p3, 1);

        System.out.println();
        System.out.println("===== TRY CANCEL PAID ORDER =====");
        order1.cancel();

        System.out.println();
        System.out.println("===== CREATE SECOND ORDER =====");

        Order order2 = new Order("O002", customer1);
        order2.addItem(p3, 1);

        System.out.println();
        order2.printInvoice();

        System.out.println();
        System.out.println("===== CHECKOUT BY BANK TRANSFER =====");
        PaymentMethod bankPayment = new BankTransferPayment("MB Bank", "123456789");
        order2.checkout(bankPayment);

        System.out.println();
        order2.printInvoice();

        System.out.println();
        System.out.println("===== FINAL PRODUCT LIST =====");
        for (Product product : products) {
            product.printInfo();
        }
    }
}