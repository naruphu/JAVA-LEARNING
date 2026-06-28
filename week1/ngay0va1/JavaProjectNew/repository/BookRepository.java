package repository;
import interfaces.Searchable;
import java.util.ArrayList;
import java.util.List;
import model1.Book;
import java.util.Optional;

public class BookRepository extends Repository<Book> implements Searchable<Book> {
    @Override
    public List<Book> search(String keyword) {
        List<Book> result = new ArrayList<>();
        for(Book book : getAll()){
            if(book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
               book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;

    }

    public Optional<Book> findById(String id) {
        for(Book book : getAll()){
            if(book.getId().equals(id)){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    public boolean updateBook(String id, double newPrice, int newQuantity) {
        Optional<Book> optionalBook = findById(id);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            book.setPrice(newPrice);
            book.setQuantity(newQuantity);
            return true;
        }
        return false;
    }

    public boolean existById(String id) {
        return findById(id).isPresent();
    }


}