package file;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import model1.*;
public class BookFileManager{
    private static final String FILE_PATH = "storage/books.txt";

    public void saveBooksToFile(List<Book> books){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));
            for(Book book : books){
                bw.write(
                        book.getId() + ", " + 
                        book.getTitle() + ", " + 
                        book.getAuthor() + ", " + 
                        book.getPrice() + ", " +
                        book.getQuantity() + ", " + 
                        book.getCategory()
                        );
                bw.newLine();
            }
            bw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> loadBooksFromFile(){
        List<Book> books = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == 6){
                    String id = parts[0].trim();
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    int quantity = Integer.parseInt(parts[4].trim());
                    Category category = Category.valueOf(parts[5].trim().toUpperCase());
                    books.add(new Book(id, title, author, price, quantity, category));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}