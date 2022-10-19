import java.io.FileInputStream;
import java.io.FileOutputStream;
/** FileTest
 *  2022/09/14
 *  파일 복사
 */
public class B_FileTest {
    public static void main(String[] args){
        //File Read
        try{
            //Input     name : 입력할 파일 경로/이름
            FileInputStream in = new FileInputStream("C:/Users/user/Downloads/FileTest_picture.jpg");
            //Output    name : 출력할 파일 경로/이름
            FileOutputStream out = new FileOutputStream("C:/Users/user/Downloads/copy.jpg");
            //in  input 가능한지 확인
            System.out.println(in.available());

            int data = 0;
            while((data=in.read())!=-1){
                System.out.println(data);
                out.write(data);
            }
            System.out.println("File write Finish!");

        }catch(Exception e){
            e.printStackTrace();
        }

        
    }
}
