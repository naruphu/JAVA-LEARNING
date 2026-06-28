package repository;
import model1.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import interfaces.Searchable;

public class CustomerRepository extends Repository<Customer> implements Searchable<Customer> {
    @Override
    public List<Customer> search(String keyword) {
        List<Customer> result = new ArrayList<>();
        for(Customer customer : getAll()){
            if(customer.getName().toLowerCase().contains(keyword.toLowerCase()) ||
               customer.getId().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(customer);
            }
        }
        return result;
    }

    public Optional<Customer> findById(String id) {
        for(Customer customer : getAll()){
            if(customer.getId().equals(id)){
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public boolean existById(String id) {
        return findById(id).isPresent();
    }
    
}