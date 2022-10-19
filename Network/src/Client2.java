import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class Client2 {
    public static void main(String[] args) throws IOException {
        //앞에꺼 서버 뒤에꺼 client
        Socket socket = new Socket("172.29.48.1",3002, null, 5004);
        BufferedInputStream in  = new BufferedInputStream(socket.getInputStream(),4096);
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream(),4096);
        BufferedInputStream fin = new BufferedInputStream(new FileInputStream("C:/Users/user/Downloads/FileTest_picture.jpg"));
        System.out.print("Socket Bound : ");
        System.out.println(socket.isBound());
        out.write("Hello, Server!".getBytes());
        int len = 0;
        byte[] buffer = new byte[4096];
        while(fin.available()>0){
            out.write(fin.read());
        }
        fin.close();
        System.out.println(in.read());

    }
}
