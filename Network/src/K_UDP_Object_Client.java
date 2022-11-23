import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class K_UDP_Object_Client
{
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(3000)) {
            byte[] buffer = new byte[1024 * 1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            System.out.println("Packet Receive!");
            ObjectInputStream in = new ObjectInputStream( new ByteArrayInputStream(packet.getData()));
            K_USER object = (K_USER) in.readObject();
            System.out.println("Print object");
            System.out.println(object.getClass());
            System.out.println(object);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
