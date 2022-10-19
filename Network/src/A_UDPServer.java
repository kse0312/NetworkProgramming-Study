import java.net.DatagramPacket;
import java.net.DatagramSocket;
/** UDPServer
 *  2022/09/07
 *  UDP 서버 열기
 */
class A_UDPServer {
    public static void main(String[] args){
        //서버소켓이 생성이 안되거나 문제가 생길경우 catch 실행
        //소켓에 포트를 지정해줘야 함
        //8080 소켓 생성
        try (DatagramSocket serversocket = new DatagramSocket(8080)) {
            //패킷이 얼마의 데이터를 만들 수 있는가
            //2000byte의 버퍼를 생성. 2000byte 받고나면 데이터그램을 쪼개야함
            byte[] buf = new byte[2000];
            //패킷 생성
            DatagramPacket datagram = new DatagramPacket(buf, buf.length);
            System.out.println("Server Listening...");
            while(true){
                //datagram을 받아서
                serversocket.receive(datagram);
                //datagram의 버퍼에 Client의 정보와 전송한 Data가 들어있음
                //datagram을 보낸 client의 주소와 패킷을 추출
                System.out.println("Client Address: "+datagram.getAddress().getHostAddress());
                System.out.println("Client Address: "+datagram.getPort());
                
                //byte 배열을 문자열로 반환
                String message = new String(datagram.getData());
                System.out.println("Client sended Message: "+message);
            }
        } catch (Exception e) {     //Exception -> 어디든 에러가 나면 이리 빠짐
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}