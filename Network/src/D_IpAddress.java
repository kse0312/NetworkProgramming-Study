import java.io.IOException;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**IpAddress
 * 2022/09/28
 * inet 통신
 * unicast 1:1 | multicast 1:n(group)
 */
public class D_IpAddress {
    public static void main(String[] args) throws UnknownHostException {
        try {
            //InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("[Localhost | LoopbackAddress]");
            System.out.println(InetAddress.getLocalHost());
            System.out.println(InetAddress.getLoopbackAddress());
            //Domain -> IPAddress 반환
            byte[] data = new byte[32];
            System.out.println("[getByName]");
            System.out.println(InetAddress.getByName("www.naver.com"));
            System.out.println(InetAddress.getByName("www.suwon.ac.kr"));
            //-값 출력  메모리 오류
            byte[] address = InetAddress.getByName("www.naver.com").getAddress();
            System.out.println(Arrays.toString(address));
            //-값이 나오면 +256
            for (int i = 0; i < address.length; i++) {
                if(address[i]< 0){
                    System.out.println(address[i]+256);
                } else{
                    System.out.println(address[i]);
                }
            }
            //ping을 찾   icmp를 우회하거나 포트번호를 변경한 경우 false
            System.out.println("[isReachable]");
            System.out.println(InetAddress.getByName("www.naver.com").isReachable(1000));
            System.out.println(InetAddress.getByName("www.11st.com").isReachable(1000));
            System.out.println(InetAddress.getByName("www.google.com").isReachable(1000));
            //
            System.out.println(InetAddress.getByName("127.0.0.1").isReachable(1000));
            //
        }catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
