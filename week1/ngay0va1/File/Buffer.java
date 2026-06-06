
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Buffer{
    public static void main(String[] args) {
    
        // Java Program -> Buffer -> File

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("demo3.txt"));
            bw.write("Ronaldo is the goat");
            bw.newLine(); // Dung de xuong dong, k nen dung \n
            bw.write("Messi is worse than Ronaldo OK");
            bw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Buffer thì đọc thông minh hơn
        // thay vì đọc từng ký tự
        // nó đọc một cụm dữ liệu vào BỘ NHỚ ĐỆM trước
        // File -> Buffer -> Java Program

        try {
            BufferedReader br = new BufferedReader(new FileReader("demo3.txt"));
            String line;
            while((line = br.readLine()) != null){ // Nó đọc từng dòng, khi hết file thì readLine trả null
                System.out.println(line);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}