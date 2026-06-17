package service;
import java.util.List;
import java.util.Optional;
import model1.Customer;
import repository.CustomerRepository;
public class CustomerService {
    private CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;   
    }

    public void addCustomer(Customer customer) {
        if (!customerRepo.existsById(customer.getId())) {
            customerRepo.add(customer);
            System.out.println("Customer added: " + customer.getName());
        } else {
            throw new RuntimeException("Customer with ID " + customer.getId() + " already exists.");
        }
    }

    public void removeCustomer(int id) {
        customerRepo.findById(id).ifPresentOrElse(
            customer -> {
                customerRepo.remove(customer);
                System.out.println("Customer removed: " + customer.getName());
            },
            () -> {
                throw new RuntimeException("Customer with ID " + id + " not found.");
            }
        );
    }

    public Optional<Customer> findCustomerById(int id){
        return customerRepo.findById(id);
    }

    public List<Customer> searchCustomers(String keyword) {
        return customerRepo.search(keyword);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.getAll();
    }
}
