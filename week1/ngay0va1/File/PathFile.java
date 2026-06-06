
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

class PathFile{
    public static void main(String[] args) {

        Path path = Path.of("demo3.txt");

        try {
            Files.writeString(path, "Ronaldo gonna win the world cup 2026");
            // Mặc định files.writeString là ghi đè ( xoá nội dung cũ)
            // muốn ghi thêm thôi ko xoá thì StandardOperation.APPEND;
            Files.writeString(path, "\nAND THE GOAT IS FOREVER", StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // String content = Files.readString(path);
            // TOÀN BỘ FILE THÀNH MỘT STRING LỚN
            // System.out.println(content);

            List<String> line = Files.readAllLines(path); // nó sẽ đọc toàn bộ file vào memory
            // TOÀN BỘ FILE, MỖI DÒNG LÀ MỘT PHẦN TỬ
            // nên file nhỏ thì ok, file lớn thì nên dùng BufferedReader / Files.line(path)

            for(String lines : line){
                System.out.println(lines);
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}