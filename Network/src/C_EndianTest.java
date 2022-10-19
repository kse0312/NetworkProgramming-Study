import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/** EndianTest
 *  2022/09/21
 *  Endian 정렬 순서 확인하기
 *  네트워크에서는 BIG_ENDIAN 사용
 */
public class C_EndianTest {
    private  static  final int BIG_ENDIAN = 0;
    public static void main(String[] args) {
        //nativeOrder => byteorder를 반환
        System.out.println("System default Endian:"+ByteOrder.nativeOrder().toString());

        int data = 0x01020304; //4byte
        ByteBuffer buffer = ByteBuffer.allocate(4); //버퍼 생성
        buffer.order(ByteOrder.BIG_ENDIAN);                 //endian 설정
        buffer.putInt(data);                                //값 입력
        byte[] result = buffer.array();                     //버퍼 정렬
        System.out.println("BIG_ENDIAN : "+Arrays.toString(result));

        buffer.clear();                                     //버퍼 비우기
        buffer.order(ByteOrder.LITTLE_ENDIAN);              //endian 설정
        buffer.putInt(data);                                //값 입력
        result = buffer.array();
        System.out.println("LITTLE_ENDIAN : "+Arrays.toString(result));
    }
}