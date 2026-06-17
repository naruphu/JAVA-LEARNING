package file;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model1.Customer;

public class CustomerFileManager {
    private static final String FILE_PATH = "storage/customers.txt";

    public void saveCustomersToFile(List<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Customer customer : customers) {
                writer.write(
                            customer.getId() + "," +
                            customer.getName() + "," +
                            customer.getEmail() + "," +
                            customer.getMembershipLevel()
                            );
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> loadCustomersFromFile() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 4) {

                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String email = parts[2].trim();
                    String membershipLevel = parts[3].trim();

                    customers.add(new Customer(id, name, email, membershipLevel));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
}
        return customers;
    }
}