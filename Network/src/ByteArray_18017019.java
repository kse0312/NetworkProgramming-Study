import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArray_18017019 {
    public static void main(String[] args) {
        byte[] original = new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] copy = null;
        byte[] temp = new byte[4];
        int count = 0;

        ByteArrayInputStream in = new ByteArrayInputStream(original);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.out.println("[Original Data]");
        System.out.println(Arrays.toString(original));
        try {
            while (in.available() > 0) {
                count = in.read(temp);  //temp에 넣은 만큼 한번에 처리 가능
                if(count == temp.length){
                    out.write(temp);        //단점 : 메모리를 너무 먹음
                }else{
                    out.write(Arrays.copyOfRange(temp, 0, count));
                }
                copy = out.toByteArray();
                printArrays(temp, copy, count);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void printArrays(byte[] temp, byte[] copy, int count) {
        System.out.println("[temp Data] change data:"+count);
        System.out.println(Arrays.toString(temp));
        System.out.println("[Copy Data]");
        System.out.println(Arrays.toString(copy));

    }

}
