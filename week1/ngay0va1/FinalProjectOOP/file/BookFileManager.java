package file;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model1.Book;
import model1.Category;

public class BookFileManager {
    private static final String FILE_PATH = "storage/books.txt";

    public void saveBooksToFile(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Book book : books) {
                writer.write(
                            book.getId() + "," +
                            book.getTitle() + "," +
                            book.getAuthor() + "," +
                            book.getPrice() + "," +
                            book.getQuantity() + "," +
                            book.getCategory()
                            );
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> loadBooksFromFile() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 6) {

                    int id = Integer.parseInt(parts[0].trim());
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    int quantity = Integer.parseInt(parts[4].trim());

                    Category category =
                        Category.valueOf(parts[5].trim().toUpperCase());

                    books.add(new Book(id, title, author, price, quantity, category));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
}
        return books;
    }
}
