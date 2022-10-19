import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/** UDPClient
 *  2022/09/07
 *  UDP 클라이언트 생성 -> 서버에 message 전송
 */
class A_UDPClient {
    public static void main(String[] args){
        String message = "Hello UDP Server";
        try{
            //통신을 위한 소켓을 생성, client지만 port 지정
            DatagramSocket clientSocket = new DatagramSocket(5000);

            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket p = new DatagramPacket(message.getBytes(), message.length(), serverAddress, 8080);
            
            clientSocket.send(p);
            //전송 후 반드시 닫아줄 것
            clientSocket.close();  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}