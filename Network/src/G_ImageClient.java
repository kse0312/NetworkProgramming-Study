import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class G_ImageClient {
    public static void main(String[] args) throws IOException {
        //앞에꺼 서버 뒤에꺼 client
        Socket socket = new Socket("172.29.48.1",3000, null, 5004);
        DataInputStream in  = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        FileInputStream fin = new FileInputStream("C:/Users/user/Downloads/FileTest_picture.jpg");
        System.out.print("Socket Bound : ");
        System.out.println(socket.isBound());
        out.writeUTF("Hello, Server!");
        int len = 0;
        byte[] buffer = new byte[4096];
        while(fin.available()>0){
            len = fin.read(buffer);
            if(len == buffer.length){
                out.write(buffer);
            }else{
                out.write(Arrays.copyOfRange(buffer, 0, len));
            }
            System.out.println(len);
        }
        System.out.println(in.readUTF());

    }
}
