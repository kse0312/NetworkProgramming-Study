import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class J_MulticastClient
{
    public static void main(String[] args) {
                try(MulticastSocket socket = new MulticastSocket(4000)) {
                    InetAddress groupAddress = InetAddress.getByName("224.0.0.1");
                    socket.joinGroup(groupAddress);
                    byte[] buffer = new byte[1024*1024];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    while (true) {
                        socket.receive(packet);
                        byte[] receiveData = packet.getData();
                String data = new String(receiveData, 0, packet.getLength());
                System.out.println(data);
                System.out.println("Address: "+packet.getAddress()+", Port: "+packet.getPort());
                System.out.println("========================");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
