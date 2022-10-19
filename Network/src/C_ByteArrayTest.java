import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/** ByteArrayTest
 *  2022/09/21
 *   byte 배열 original의 data를 출력
 *   단점 : byte 용량이 클 경우 시간이 굉장히 오래 걸릴 수 있다.
 */
public class C_ByteArrayTest {
        public static void main(String[] args) {
            byte[] original = new byte[]{0,1,2,3,4,5,6,7,8,9};
            /*
            byte[] original = new byte[Integer.MAX_VALUE/2];
            for(int i=0;i<original.length;i++){
                original[i]=(byte)1;
            }
                전부 읽어오기 전에 정지
             */
            //original 배열에서 데이터를 가져옴
            ByteArrayInputStream in = new ByteArrayInputStream(original);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            //out을 bytestream으로 바꿔줌
            System.out.println("[before]");
            System.out.println(Arrays.toString(out.toByteArray()));
            int data = 0;
            //데이터를 다 읽고나면 -1를 return
            /* 01 비효율적
            while((data = in.read()) != -1){
                out.write(data);
                //System.out.println(data);
            }
             */
            byte[] temp = new byte[3];      //임시 배열
            while(in.available()>0){        //몇개를 읽어올 수 있는지 확인
                try{
                    in.read(temp);          //temp에 넣은 만큼 한번에 처리 가능
                    System.out.print("[temp] ");
                    System.out.println(Arrays.toString(temp));
                    out.write(temp);        //단점 : 메모리를 너무 먹음
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            //만약 temp보다 읽을 값이 적다면 이전값이 남아있게 된다 byte size 3
            //그래서 이전에 남아있던 값도 out에 같이 들어가게 된다.
            System.out.println("Read Finish");
            System.out.println("[after]");
            System.out.println(Arrays.toString(out.toByteArray()));
        }
}
