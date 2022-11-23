import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class I_UDPClient {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                DatagramSocket socket = new DatagramSocket()) { //port번호 입력 x -> client (필요가 엄숴)
            while(true){
                byte[] buffer = in.readLine().getBytes();//new byte[1024 * 1024];
                InetAddress address = InetAddress.getByName("172.16.37.228");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 8080);
                socket.send(packet);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}