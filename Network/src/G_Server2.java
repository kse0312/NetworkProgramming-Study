import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class G_Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        SocketAddress address = new InetSocketAddress("172.29.48.1",3002);
        serverSocket.bind(address);
        System.out.println(serverSocket.isBound());
        while(true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client Accept!");
            BufferedInputStream in = new BufferedInputStream(clientSocket.getInputStream(),4096);
            BufferedOutputStream out = new BufferedOutputStream(clientSocket.getOutputStream(),4096);
            BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream("C:/Users/user/Downloads/copy.jpg"));
            while(in.available()>0){
                fout.write(in.read());
            }
            fout.close();
            System.out.println("Read Finish");
            String message = "Hello Client!";
            out.write(("[ECHO]"+message).getBytes());
            clientSocket.close();
        }


    }
}
