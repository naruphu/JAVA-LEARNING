import java.util.*;
class MainProduct{
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("AO THUN", 100.000));
        products.add(new Product("AO THUN 2", 150.000));
        products.add(new Product("AO THUN 3", 200.000));

        products.stream()
        .filter(product -> product.getName().equals("AO THUN"))
        .forEach(product -> System.out.println(product.getPrice()));    
       
    }
}