package repository;
import java.util.ArrayList;
import java.util.List;

public class Repository <T> {
    private List<T> items;

    public Repository() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);     
    }

    public void remove(T item) {
        items.remove(item);
    }

    public List<T> getAll() {
        return items;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public int size(){
        return items.size();
    }

}
