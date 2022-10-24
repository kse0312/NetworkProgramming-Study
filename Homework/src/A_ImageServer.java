import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * 20221012
 * 서버로 이미지 복사하기 과제
 * Server
 */
public class A_ImageServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        SocketAddress address = new InetSocketAddress("172.29.48.1",3000);
        serverSocket.bind(address);
        System.out.println(serverSocket.isBound());
        while(true) {
            //accept 하면 client의 socket를 받은 것
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client Accept!");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            FileOutputStream fout = new FileOutputStream("C:/Users/user/Downloads/copy.jpg");
            System.out.println(in.readUTF());
            byte[] buffer = new byte[4096];
            int len;
            while (in.available() > 0) {
                len = in.read(buffer);
                //write는 무조건 1byte씩 전송한다
                //겉보기에는 4byte씩 가는 것같지만 사실 1byte를 4번 전송하는 것
                //fout.write(buffer);

                //len만큼의 길이를 전송하기 떄문에 이게 더 빠르다.
                fout.write(buffer, 0, len);
                System.out.println(len);
            }
            fout.close();
            System.out.println("Read Finish");
            String message = "Hello Client!";
            out.writeUTF("[ECHO]" + message);
            clientSocket.close();
        }
    }
}
