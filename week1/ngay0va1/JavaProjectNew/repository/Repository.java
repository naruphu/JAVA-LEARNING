package repository;
import java.util.ArrayList;
import java.util.List;
public class Repository <T>{
    private List<T> items;

    public Repository(){
        this.items = new ArrayList<>();
    }

    public void add(T item){
        if(item == null){
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    public void remove(T item){
        if(item == null){
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.remove(item);
    }

    public List<T> getAll(){
        return items;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public int size(){
        return items.size();
    }

}