// Giả sử user upload avartar, backend cần lưu vào
// uploads/avatar.png
// Tư duy sẽ là 
// 1. Tạo Path tới folder uploads
// 2. Kiểm tra/tạo folder nếu chưa có
// 3. Tạo Path tới file avatar.png
// 4. Ghi dữ liệu vào file




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class UploadSimulation {
    public static void main(String[] args) {

        Path uploadDir = Path.of("uploads");
        Path filePath = uploadDir.resolve("avatar.txt"); // dòng này quan trọng
        // nghĩa là uploads + avatar.txt = uploads/avatar.txt

        try {
            Files.createDirectories(uploadDir);

            Files.writeString(filePath, "Fake avatar content");

            System.out.println("Lưu file thành công: " + filePath);

        } catch (IOException e) {
            System.out.println("Lưu file thất bại");
            e.printStackTrace();
        }
    }
}