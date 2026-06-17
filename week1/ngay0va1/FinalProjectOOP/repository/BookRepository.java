package repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import interfaces.Searchable;
import model1.Book;


public class BookRepository extends Repository<Book> implements Searchable<Book> {
    @Override
    public List<Book> search(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book book : getAll()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public Optional<Book> findById(int id) {
        for (Book book : getAll()) {
            if (book.getId() == id) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }
    
    public boolean existsById(int id) {
        return findById(id).isPresent();
    }

}
