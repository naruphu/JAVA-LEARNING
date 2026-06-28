package file;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import model1.*;
public class CustomerFileManager{
    private static final String FILE_PATH = "storage/customers.txt";

    public void saveCustomersToFile(List<Customer> customers){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));
            for(Customer customer : customers){
                bw.write(
                    customer.getId() + ", " +
                    customer.getName() + ", " +
                    customer.getEmail() + ", " +
                    customer.getPhone()
                );
            }
            bw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> loadCustomer(){
        List<Customer> customer = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == 4){
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String email = parts[2].trim();
                    String phone = parts[3].trim();

                    customer.add(new Customer(id, name, email, phone));

                }
            }
            
        } catch (Exception e) {
        }
        return customer;
    }

}