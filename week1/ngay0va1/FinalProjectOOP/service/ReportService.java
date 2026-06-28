package service;
import repository.BookRepository;
import repository.OrderRepository;
import model1.Book;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.Comparator;

public class ReportService {
    private BookRepository bookRepository;
    private OrderRepository orderRepository;

    public ReportService(BookRepository bookRepository, OrderRepository orderRepository) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    public void printBook() {
        System.out.println("Book Report:");
        bookRepository.getAll().forEach(System.out::println); // system.out::println is a method reference
        // it is equivalent to: book -> System.out.println(book)

    }

    public List<Book> findExpensiveBook(){
        return bookRepository.getAll().stream()
                .filter(book -> book.getPrice() > 200000)
                .collect(Collectors.toList());
    }

    public List<String> getBookName(){
        return bookRepository.getAll().stream()
                .map(Book::getTitle) // book -> book.getTitle()
                .collect(Collectors.toList());
    }

    public double getTotalRevenue(){
        return orderRepository.getAll().stream()
                .flatMap(order -> order.getItems().stream())
                .mapToDouble(item -> item.getBook().getPrice() * item.getQuantity())
                .sum();
    }

    public Optional<Book> findMostExpensiveBook() {
        return bookRepository.getAll().stream()
                .max(Comparator.comparingDouble(Book::getPrice));
    }

    public List<Book> outOfStockBooks() {
        return bookRepository.getAll().stream()
                .filter(book -> book.getQuantity() < 5)
                .collect(Collectors.toList());
    }

    




}