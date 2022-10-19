import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2022/09/28
 * TCPServer
 */

public class D_Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;
    public void startServer(){
        //port:   | backlog : 몇변까지 접속할 것인지
        try {
            //TCP 서버를 열어줌
            serverSocket = new ServerSocket(3000);
            System.out.println("[Listen...]");
            //서버에 ip주소 지정 bind()  serverSocket.bind();
            //찾아올때 필요한 IP와 PORT를 입력
            //serverSocket.bind(new InetSocketAddress(Inet4Address.getByName("178.16.39.168"),3000));
            //연결 수용   상대방의 socket을 얻을 수 있음
            clientSocket = serverSocket.accept();
            //계속 대기상태
            System.out.println("[accept]");
            //filter -> outputstream이 필요.
            //autoFlush : true 안해주면 버퍼가 안차서 출력 x
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            //획득한 소켓의 in을 쓰겠다
            in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println(message);
            if(message.equals("Hello, Server!")){
                out.println("Hello, Cilent!111111111");
            }else{
                out.println("Get Out!!");
            }
            out.println(message);
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void stopServer() throws IOException{
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args) {
        D_Server d_server = new D_Server();
        d_server.startServer();
        /*
        try {
            d_server.stopServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */

    }
}
