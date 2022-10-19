import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;

public class G_Server {
    public static void main(String[] args) throws IOException {
        /*
        1. unbound socket 생성
            ServerSocket socket = new ServerSocket();
        2. socket에 포트번호를 부여하면서 localhost로 bind
            ServerSocket socket = new ServerSocket(3000);
        3. socket에 포트번호를 부여하면서 backlog = 10, 한번에 10명이 접속 할 수 있는 localhost로 bind
            ServerSocket socket = new ServerSocket(3000,10);
        4. socket에 포트번호를 부여하면서 backlog = 10, 한번에 10명이 접속 할 수 있는 localhost로 bind
            InetAddress address = Inet4Address.getLocalhost(); << InetAddress가 부모이기 떄문에 4를 6으로 바꿔도 가능
            ServerSocket socket = new ServerSocket(3000,10,address);
         */
        ServerSocket serverSocket = new ServerSocket();
        SocketAddress address = new InetSocketAddress("172.29.48.1",3001);
        serverSocket.bind(address);
        System.out.println(serverSocket.isBound());
        while(true){
            /*
            System.out.println("[Server Socket]");
            System.out.println(serverSocket.getInetAddress());
            System.out.println(serverSocket.getLocalPort());

            System.out.println("[Client Socket]");
            System.out.println(clientSocket.getInetAddress());
            System.out.println(clientSocket.getPort());

            //local -> 무조건 endpoint, 내꺼
            System.out.println("[Client Socket] - Local");
            System.out.println(clientSocket.getLocalAddress());
            System.out.println(clientSocket.getLocalPort());
             */
            //accept 하면 client의 socket를 받은 것
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client Accept!");
            DataInputStream   in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            FileOutputStream fout = new FileOutputStream("C:/Users/user/Downloads/copy.jpg");
            System.out.println(in.readUTF());
            byte[] buffer = new byte[4096];
            int len;
            while(in.available()>0){
                len=in.read(buffer);
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
            out.writeUTF("[ECHO]"+message);
            clientSocket.close();
        }


    }
}
