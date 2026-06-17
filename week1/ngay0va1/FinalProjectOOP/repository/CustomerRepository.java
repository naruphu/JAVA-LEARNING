package repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import interfaces.Searchable;
import model1.Customer;


public class CustomerRepository extends Repository<Customer> implements Searchable<Customer> {
    @Override
    public List<Customer> search(String keyword) {
        List<Customer> results = new ArrayList<>();
        for (Customer customer : getAll()) {
            if (customer.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                customer.getEmail().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(customer);
            }
        }
        return results;

        public Optional<Customer> findById(int id) {
            for (Customer customer : getAll()) {
                if (customer.getId() == id) {
                    return Optional.of(customer);
                }
            }
            return Optional.empty();
        }
        public boolean existsById(int id) {
            return findById(id).isPresent();
        }
    }
    
}
