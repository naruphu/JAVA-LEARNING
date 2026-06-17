package service;
import repository.BookRepository;
import model1.Book;
import java.util.List;
import java.util.Optional;

import exception.BookNotFoundException;

public class BookService {
    private BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addBook(Book book) {
        if (!bookRepo.existsById(book.getId())) {
            bookRepo.add(book);
            System.out.println("Book added: " + book.getTitle());
        } else {
            throw new RuntimeException("Book with ID " + book.getId() + " already exists.");
    }
}

    public void removeBook(int id) {
        bookRepo.findById(id).ifPresentOrElse(
            book -> {
                bookRepo.remove(book);
                System.out.println("Book removed: " + book.getTitle());
            },
            () -> {
                throw new BookNotFoundException("Book with ID " + id + " not found.");
            }
        );
    }
    // remove nếu ko viết theo kiểu lambda thì nó kiểu vậy
    /*
    Optional<Book> result = bookRepo.findById(id);

    if (result.isPresent()) {

        Book book = result.get();

        bookRepo.remove(book);

        System.out.println(
            "Book removed: " + book.getTitle()
        );

    } else {

        throw new BookNotFoundException(
            "Book with ID " + id + " not found."
        );
    }
     */

    public Optional<Book> findBookById(int id) {
        return bookRepo.findById(id);
    }

    public List<Book> searchBooks(String keyword) {
        return bookRepo.search(keyword);
    }

    public List<Book> getAllBooks() {
        return bookRepo.getAll();
    }
    

}
