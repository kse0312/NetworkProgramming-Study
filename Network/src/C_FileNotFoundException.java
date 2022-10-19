import java.io.*;

/**
 * 2022/09/21
 * FileNotFoundException
 */
public class C_FileNotFoundException {
    public static void main(String[] args) throws FileNotFoundException {
        //DataOutputStream out = new DataOutputStream(new FileOutputStream("./abc.x"));
        DataInputStream in = new DataInputStream(new FileInputStream("./abc.x"));
        try {
            //out.writeByte(25);
            //out.writeInt(20);
            //out.writeBoolean(true);
            //out.close();
            boolean b = in.readBoolean();
            int a = in.readByte();
            System.out.println();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
