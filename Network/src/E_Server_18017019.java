import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class E_Server_18017019 {
    // TCP Server
    ServerSocket serverSocket;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader  in;
    public static void main(String[] args) {
        E_Server_18017019 main = new E_Server_18017019();
        main.startServer();
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(Inet4Address.getByName("172.29.48.1"), 3000));
            System.out.println("Listen......");
            clientSocket = serverSocket.accept();
            System.out.println("Accept");
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            FileOutputStream fout = new FileOutputStream("C:/Users/user/Downloads/copy.jpg");
            int data;
            byte[] temp = new byte[16];
            while(true){
                if((data= in.read())!=-1){
                    fout.write(data);
                }
                else{
                    fout.close();
                    System.out.println("File write Finish");
                    out.println("File write Finish");
                    stopServer();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}
