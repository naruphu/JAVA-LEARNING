package service;
import model1.Book;
import repository.BookRepository;
import java.util.Optional;

public class BookService {
    
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if(book == null){
            throw new IllegalArgumentException("Book cannot be null");
        }
        if(book.getPrice() < 0){
            throw new IllegalArgumentException("Book price cannot be negative");
        }
        if(book.getQuantity() < 0){
            throw new IllegalArgumentException("Book quantity cannot be negative");
        }

        if(bookRepository.getAll().stream().anyMatch(b -> b.getId().equals(book.getId()))){
            throw new IllegalArgumentException("Book with the same ID already exists");
        }
        bookRepository.add(book);
    }

    public void removeBook(String bookId) {
        if(bookId == null || bookId.isEmpty()){
            throw new IllegalArgumentException("Book ID cannot be null or empty");
        }
        Book bookToRemove = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with ID: " + bookId));
        bookRepository.remove(bookToRemove);
    }

    public Optional<Book> getBookById(String bookId) {
        if(bookId == null || bookId.isEmpty()){
            throw new IllegalArgumentException("Book ID cannot be null or empty");
        }
        return bookRepository.findById(bookId);
    }

    public boolean updateBook(String id, double newPrice, int newQuantity) {
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("Book ID cannot be null or empty");
        }
        if(newPrice < 0){
            throw new IllegalArgumentException("New price cannot be negative");
        }
        if(newQuantity < 0){
            throw new IllegalArgumentException("New quantity cannot be negative");
        }
        return bookRepository.updateBook(id, newPrice, newQuantity);
    }

    public boolean existById(String id) {
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("Book ID cannot be null or empty");
        }
        return bookRepository.existById(id);
    }
}