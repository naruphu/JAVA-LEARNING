package repository;
import model1.Order;
import java.util.Optional;
public class OrderRepository extends Repository<Order> {
    public Optional<Order> findById(String id) {
        for(Order order : getAll()){
            if(order.getId().equals(id)){
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }
}