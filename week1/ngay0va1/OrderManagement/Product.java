class Product{
    private String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock){
        this.id = id;
        this.name = name;
        if(price < 0) this.price = 0;
        else this.price = price;
        if(stock < 0) this.stock = 0;
        else this.stock = stock;
    }

    public double getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }

    public String getName(){
        return name;
    }

    public boolean reduceStock(int quantity){
        if(quantity <= 0 ){
            System.out.println("QUANLITY IS INVALID");
            return false;
        }
        if(quantity > stock){
            System.out.println("NOT ENOUGH STOCK FOR PRODUCT: " + name);
            return false;
        }
        stock -= quantity;
        return true;
    }

    public void increaseStock(int quantity){
        if(quantity <= 0){
            System.out.println("INVALID");
            return;
        }
        stock += quantity;
    }

    public void printInfo(){
        System.out.println(id + " - " + name + " - " + price + " - stock: " + stock);
    }
    
}