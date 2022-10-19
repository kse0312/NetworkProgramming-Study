import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Socket;

public class D_Cilent {
    Socket cilentsocket;
    PrintWriter out;
    BufferedReader in;
    public void serverConnection(){
        try {
            //cilentsocket= new Socket("127.0.0.1",3000);
            //cilent 서버에 연결
            cilentsocket = new Socket(Inet4Address.getByName("172.16.39.168"),3000);
            out = new PrintWriter(cilentsocket.getOutputStream(),true);
            in  = new BufferedReader(new InputStreamReader(cilentsocket.getInputStream()));
            System.out.println("[Cilent Ready...]");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void sendMessage(String message){
        out.println(message);
        String response = null;
        try {
            response = in.readLine();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        D_Cilent d_cilent = new D_Cilent();
        d_cilent.serverConnection();
        d_cilent.sendMessage("Hello, Server! s");

    }
}
