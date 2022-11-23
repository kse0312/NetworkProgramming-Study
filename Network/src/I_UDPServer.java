import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.SQLOutput;

public class I_UDPServer {
    //DatagramSocket : Socket Creator
    //DatagramPacket : UDP Packet
    public static void main(String[] args) {
        // 172.16.37.228
        // 교수님 172.16.39.188
        try(DatagramSocket socket = new DatagramSocket(8080)){
            byte[] buffer = new byte[1024 * 1024];
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
            while(true){
                System.out.println("Waiting..............");
                socket.receive(packet);
                byte[] receivedData = packet.getData();
                System.out.printf("[Client] IP: %s, Port : %d \n",packet.getAddress().getHostAddress(),packet.getPort());
                System.out.printf("Offset : %d, Length : %d\n",packet.getOffset(), packet.getLength());
                String message = new String(receivedData,packet.getOffset(),packet.getLength());
                System.out.println("[message] "+ message+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
