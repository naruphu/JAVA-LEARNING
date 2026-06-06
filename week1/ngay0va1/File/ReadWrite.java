
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// trong file java bắt try-catch hoac throws
// vì nó biết là có thể thao tác đó thất bại
// do ví dụ file đó k tồn tại, địa chỉ đó k tồn tại abc
// nên nó bắt mình xử lý trước khi thất bại thi sẽ làm gì

class ReadWrite{
    public static void main(String[] args) {

        // FileWriter
        // Dung de ghi du lieu dang ky tu / text
        try {
            FileWriter fw = new FileWriter("demo2.txt");
            fw.write("Naruphu akakaka");
            fw.write("\nNaruphu akakaka 123");

            fw.close();
            
        } catch (IOException e) {
            e.printStackTrace(); // try with resources
        }

        // FileReader
        // Dung de doc du lieu dang ky tu / text
        try {
            FileReader fr = new FileReader("demo.txt");
            int ch;
            while((ch = fr.read()) != -1){
                System.out.print((char) ch);;
            }
            System.out.println();
            fr.close();
            
        } catch (IOException e) {
            e.printStackTrace(); // try with resources
        }

        // Vấn đề của FileReader / FileWriter là thường nó đọc TỪNG KÝ TỰ
        // Nên file nhỏ thì không sao nhưng lớn thì chậm
    }
}