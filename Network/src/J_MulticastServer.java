import java.io.IOException;
import java.net.*;

/**
 * unicast : 상대방의 ip, port를 알아야 전송 가능
 * 
 */
public class J_MulticastServer {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket()) {
            String message = "ㅎㅇㅎㅇ";
            byte[] buffer = message.getBytes();
            while (true) {
                InetAddress groupAddress = InetAddress.getByName("224.0.0.1");
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length, groupAddress, 4000);
                socket.send(packet);
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
