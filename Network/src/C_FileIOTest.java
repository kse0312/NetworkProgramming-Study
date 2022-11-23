import java.io.*;

/**FileIOTest
 * 2022/09/21
 * 파일 읽어오기/쓰기
 * sample.txt
 */
public class C_FileIOTest {
    public static void main(String[] args) {
        try {

            CharArrayReader in2 = new CharArrayReader("asdf".toCharArray());  //문자형 배열 가능
            System.out.println((char) in2.read());
            FileReader in = new FileReader("C:/Users/user/Desktop/네트워크/Network/src/C_EndianTest.java");
            //한글 안깨지고 출력 가능
            //reader로 읽어오면 문자형으로 데이터를 가져옴 -> 자동 인코딩
            int data = 0;
            while((data = in.read()) !=-1){
                System.out.print((char) data);
            }
            //FileInputStream in = new FileInputStream("C:/Users/user/Desktop/네트워크/Network/src/C_EndianTest.java");
            //FileInputStream in = new FileInputStream("C:/Users/user/Desktop/네트워크/Network/sample.txt");
            /* FileInputStream 읽어오기 **한글 꺠짐**
            while(in.available()>0){
                System.out.print((char) in.read());
            }
             */
            /* 파일 쓰기
            FileOutputStream out = new FileOutputStream("./sample.txt");
            for(int i=65;i<91;i++){
                //System.out.println((char)i);
                out.write(i);
            }
             */
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
