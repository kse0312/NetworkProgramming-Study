import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class J_BroadcastServer {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket()) {
            /**
             * 보내는 쪽에서 브로드캐스트 설정만 해주면 됨
             * socket.setBroadcast(true);
             */
            String message = "ㅎㅇㅎㅇ";
            byte[] buffer = message.getBytes();
            while (true) {
                /** 브로드 캐스트 주소로 설정 */
                InetAddress groupAddress = InetAddress.getByName("255.255.255.255");
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length, groupAddress, 4000);
                socket.send(packet);
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
