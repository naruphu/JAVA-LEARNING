package service;
import java.util.Comparator;
import repository.*;
import java.util.List;
import model1.*;
import java.util.stream.*;
import java.util.Optional;
public class ReportService{
    private BookRepository bookRepository;
    private OrderRepository orderRepository;

    public ReportService(BookRepository bookRepository, OrderRepository orderRepository){
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    public void printBook(){
        System.out.println("Print books: ");
        bookRepository.getAll().forEach(book -> System.out.println(book));
    }

    public List<Book> findExpensiveBook(){
        return bookRepository.getAll().stream()
                .filter(book -> book.getPrice() > 200)
                .collect(Collectors.toList());
    }

    public List<String> getName(){
        return bookRepository.getAll().stream()
                .map(book -> book.getTitle())
                .collect(Collectors.toList());
    }

    public double getTotalRevenue(){
        return orderRepository.getAll().stream()
                .flatMap(order -> order.getItems().stream())
                .mapToDouble(item -> item.getBook().getPrice() * item.getQuantity())
                .sum();
    }

    public Optional<Book> findMostExpensiveBook(){
        return bookRepository.getAll().stream()
                .max(Comparator.comparingDouble(Book::getPrice));
    }

    public List<Book> outOfStockBook(){
        return bookRepository.getAll().stream()
                .filter(book -> book.getQuantity() < 5)
                .collect(Collectors.toList());
    }


}