class OrderItem{
    Product product;    
    private int quantity;

    public OrderItem(Product product, int quantity){
        this.product = product;
        if(quantity <= 0){
            System.out.println("INVALID");
            System.exit(0);
        }
        else this.quantity = quantity;
    }

    public Product getProduct(){
        return product;
    }
    public int getQuantity(){
        return quantity;
    }

    public double calculateSubtotal(){
        return  (double) ( product.getPrice() * quantity ) ;
    }

    public void printInfo(){
        System.out.println(
                product.getName()
                + " | Price: " + product.getPrice()
                + " | Quantity " + quantity
                + " | Subtotal " + calculateSubtotal()

        );
    }
}
