import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
class MoreAboutPathFile{
    public static void main(String[] args) {
        // CHECK FILE CO TON TAI KHONG

        Path path = Path.of("skills.txt");

        if (Files.exists(path)) {
            System.out.println("File tồn tại");
        } else {
            System.out.println("File không tồn tại");
        }

        // TAO FOLDER

        Path folder = Path.of("uploads");

        try {
            Files.createDirectories(folder); // DUNG createDirectories() THAY VI createDirectory() 
            // VI createDirectories() SE TAO CA FOLDER CHA NEU CAN
            System.out.println("Tạo folder thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}
