import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 직렬화 Serialization
 * 서버와 클라이언트에 동일한 클래스 필요
 * 직렬된 형태로 object를 전송
 * 패킷 프로토콜을 만들어야 함
 */
public class K_UDP_Object_Server
{
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(5000)) {
            K_USER user = new K_USER("뚜룻뚜","12345678",1L);
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteStream);
            out.writeObject(user);
            out.flush();
            byte[] buffer = byteStream.toByteArray();
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length,serverAddress,3000);
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
