package service;
import java.util.List;
import java.util.Optional;
import model1.Customer;
import repository.CustomerRepository;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(String id, String name, String email, String phone) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }   
        if (email == null || email.isEmpty()) {     
            throw new IllegalArgumentException("Customer email cannot be null or empty");
        }
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Customer phone cannot be null or empty");
        }
        Customer customer = new Customer(id, name, email, phone);
        customerRepository.add(customer);
    }

    public void addCustomer2(Customer customer){
        customerRepository.add(customer);
    }

    public void removeCustomer(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        Customer customerToRemove = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + id));
        customerRepository.remove(customerToRemove);
    }

    public List<Customer> searchCustomers(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            throw new IllegalArgumentException("Search keyword cannot be null or empty");
        }
        return customerRepository.search(keyword);
    }


    public Optional<Customer> getCustomerById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        return customerRepository.findById(id);
    }

    public boolean existById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        return customerRepository.existById(id);
    }


}