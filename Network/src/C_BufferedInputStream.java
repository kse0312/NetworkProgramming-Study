import java.io.*;
import java.util.Date;

/**
 * 2022/09/21
 * 대용량 파일 읽어올 떄 버퍼를 사용하여 속도를 향상 시킨다
 */
public class C_BufferedInputStream {
    public static void main(String[] args) {
        try{
            FileInputStream in = new FileInputStream("./Myfile");
            BufferedInputStream bufIn = new BufferedInputStream(in,10000);
            //BufferedInputStream bufIn = new BufferedInputStream(new FileInputStream("./Myfile"));
            int data = 0;

            System.out.println("Read Start");
            System.out.println(new Date());
            /*
            while((data = in.read())!=-1){
                System.out.println(data);
            }
            엄청나게 오래 걸릴꺼임
             */
            while((data = bufIn.read())!=-1){
                //System.out.println(data);
            }
            bufIn.close();
            System.out.println("Read Finish");
            System.out.println(new Date());
            //createFile();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //파일 생성
    public static void createFile() throws IOException {
        RandomAccessFile file = new RandomAccessFile("./Myfile","rw");
        long fileSize = 1024 * 1024 * 1024 * 3L; //L붙어야 LONG TYPE -> 3GB file
        file.setLength(fileSize);
    }
}
