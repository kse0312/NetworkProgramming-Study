import java.io.ByteArrayOutputStream;
import java.io.IOException;
/** IOTest
 *  2022/09/14
 *  파일 복사
 */
class B_IOTest{
    public static void main(String[] args) throws IOException{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        /*
        System.out.println("Before: "+out.size());
        out.write(65);
        System.out.println("After1: "+out.size());
         */
        /*
        좋지 못한 방법 1 : overhead
        for(int i=0;i<91;i++){
            out.write(i);
        }
        System.out.println("After2: "+out.size());
        */
        byte[] code = new byte[50];
        for(int i=65;i<91;i++){
            code[i-65]=(byte) i;
        }
        //out.write(code);
        //한번에 읽어주기 -> 상속받아서 사용
        out.write(code, 0, code.length);
        System.out.println("After3: "+out.size());
        System.out.println(out.toString());
    }
}