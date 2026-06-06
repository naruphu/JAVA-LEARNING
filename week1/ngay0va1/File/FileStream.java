
import java.io.FileInputStream;
import java.io.IOException;

// Nhuoc diem cuar FileInput/OutputStream la no lam viec voi BYTE, chu k phai voi TEXT 

class FileStream{
    public static void main(String[] args) {

        // FileOutputStream
        // Dung de luu du lieu dang byte vao file

        try {
            FileOutputStream fos = new FileOutputStream("demo.txt");
            String text = "Hello java";
            fos.write(text.getBytes());
            fos.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        // FileInputStream
        // Dung khi xu ly ANH, VIDEO, PDF, FILE ZIP, FILE NHI PHAN

        try {
            FileInputStream fis = new FileInputStream("demo.txt");
            int data;
            while((data = fis.read()) != -1){
                System.out.print((char) data);
            }
            System.out.println();
            fis.close();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}