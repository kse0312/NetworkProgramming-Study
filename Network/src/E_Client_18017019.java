import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Arrays;

public class E_Client_18017019 {
    Socket clientSocket;
    BufferedWriter out;
    BufferedReader in;
    public static void main(String[] args) {
        E_Client_18017019 main = new E_Client_18017019();
        main.serverConnection();
        main.sendMessage("C:/Users/user/Downloads/test.png");
    }
    public void serverConnection() {
        try {
            // clientSocket = new Socket("127.0.0.1", 3000);
            clientSocket = new Socket(Inet4Address.getByName("172.29.48.1"), 3000);
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            FileInputStream fin = new FileInputStream(message);
            int data = 0;
            int count = 0;
            byte[] temp = new byte[16];
            while(fin.available()>=-1){
                count = fin.read(temp);
                if(count == temp.length){
                    //out.write(String.valueOf(temp));        //단점 : 메모리를 너무 먹음
                }else{
                    //out.write(String.valueOf(Arrays.copyOfRange(temp, 0, count)));
                }
            }

            /*
            do{
                data=fin.read();
                //System.out.println(data);
                out.write(data);
            }while(data!=-1);

             */
            System.out.println("File Send Finish");
            String response = null;
            try {
                response = in.readLine();
                System.out.println(response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
