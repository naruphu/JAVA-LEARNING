
import java.util.ArrayList;
import java.util.List;

class Order{
    private String orderId;
    private Customer customer;
    private List<OrderItem> items;
    private String status;

    public Order(String orderId, Customer customer){
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>(); 
        this.status = "PENDING";

    }

    public String getOrderId(){
        return orderId;
    }
    public String getStatus(){
        return status;
    }

    public void addItem(Product product, int quantity){
        if(!status.equals("PENDING")){
            System.out.println("Can not add item, order is not pending");
            return;
        }
        if(product == null){
            System.out.println("product is invalid");
            return;
        }
        if(quantity <= 0){
            System.out.println("INVALID");
            return;
        }
        if(quantity > product.getStock()){
            System.out.println("NOT ENOUGH STOCK");
            return;
        }

        OrderItem item = new OrderItem(product, quantity);
        items.add(item);    

        System.out.println("ADD PRODUCT TO ORDER: " + product.getName() + " - " + quantity);
    }

        public double calculateTotal(){
            double total = 0;
            for(OrderItem item : items){
                total += item.calculateSubtotal();
            }
            return total;
        }

    public void checkout(PaymentMethod payment){
        if(status.equals("Cancelled")){
            System.out.println("Cannot checkout cause order was cancalled");
            return;
        }
        if(status.equals("Paid")){
            System.out.println("Cannot checkout cause already been paid");
            return;
        }

        if(items.isEmpty()){
            System.out.println("Cannot checkout, order has no item");
            return;
        }

        if(payment == null){
            System.out.println("Payment is invalid");
            return;
        }

        for(OrderItem item : items){
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if(quantity > product.getStock()){
                System.out.println("Not enough stock for the product: " + product.getName());
                System.out.println("Checkout failed");
                return;
            }
        }
        for(OrderItem item : items){
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            product.reduceStock(quantity);
        }
        double total = calculateTotal();
        payment.pay(total);
        status = "PAID";
        System.out.println("CHECKOUT SUCCESSFULLY!");

    }

    public void cancel(){
        if(status.equals("PAID")){
            System.out.println("Cannot cancel cause order has already been paid");
            return;
        }
        if(status.equals("CANCELLED")){
            System.out.println("Order was already cancelled");
            return;
        }
        status = "CANCELLED";
        System.out.println("Order cancelled successfully");
    }

    public void printInvoice(){
        System.out.println("-------------INVOICE----------------");
        System.out.println("ORDER ID: " + orderId);
        System.out.println("CUSTOMER: " + customer.getInfo());
        System.out.println("STATUS: " + status);
        System.out.println();

        System.out.println("ITEMS: ");
        if(items.isEmpty()) System.out.println("No items in this order");
        else{
            for(int i = 0; i < items.size(); i++){
                System.out.print((i + 1) + ". ");
                items.get(i).printInfo();
            }
        }

        System.out.println();
        System.out.println("Total: " + calculateTotal());
        System.out.println("===============================");
    }
}
    
