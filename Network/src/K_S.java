import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 직렬화 Serialization
 * 서버와 클라이언트에 동일한 클래스 필요
 * 직렬된 형태로 object를 전송
 * 패킷 프로토콜을 만들어야 함
 */
public class K_S
{
    public static void main(String[] args) {
        K_USER user = new K_USER("USER1", "123456678",1L);
        saveObject(user);
        readObject();
    }

    public static  void readObject(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("./user.obj"));
            K_USER user = (K_USER) in.readObject(); // readObject는 Object type으로 반환하기 떄문에 () 필요
            System.out.println(user);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void saveObject(K_USER user){
        //stream 자동으로 닫아주는 거 try(stream)
        //try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./user.obj"));) {
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./user.obj"));
            out.writeObject(user);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
