import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
/** ByteArray_
 *  2022/09/21 과제
 *  temp 배열에 남아있는 이전에 읽어드린 값이
 *  out에 같이 들어가는 문제 해결하기
 */
public class C_ByteArray_ {
    public static void main(String[] args) {
        byte[] original = new byte[]{0,1,2,3,4,5,6,7,8,9};
        //original 배열에서 데이터를 가져옴
        ByteArrayInputStream in = new ByteArrayInputStream(original);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //out을 bytestream으로 바꿔줌
        System.out.print("[before]");
        System.out.println(Arrays.toString(out.toByteArray()));
        int data = 0;
        byte[] temp = new byte[6];      //임시 배열
        while(in.available()>0){        //몇개를 읽어올 수 있는지 확인
            try{
                int count = in.read(temp);  //temp에 넣은 만큼 한번에 처리 가능
                System.out.print(count+" ");
                System.out.println(Arrays.toString(temp));
                if(count == temp.length){
                    out.write(temp);        //단점 : 메모리를 너무 먹음
                }else{
                    out.write(Arrays.copyOfRange(temp, 0, count));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Read Finish");
        System.out.print("[after]");
        System.out.println(Arrays.toString(out.toByteArray()));
    }
}
