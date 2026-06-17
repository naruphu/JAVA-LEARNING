package repository;
import java.util.Optional;
import model1.Order;

public class OrderRepository extends Repository<Order> {
    public Otional<Order> findById(int id) {
        for (Order order : getAll()) {
            if (order.getId() == id) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }
}
