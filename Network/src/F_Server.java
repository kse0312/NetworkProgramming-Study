import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 22/10/04
 * Object 통신하기
 *
 * 객체 직렬화 -> class의 instance들을 1열된 데이터로 만듦
 * 직렬화 -> 역직렬화 -> 복원가능
 */
public class F_Server {
    public static void main(String[] args) {
        //saveObject();
        //loadObject();
        //loadObject2();
        serialization2();
        deserialization2();
    }
    public static void deserialization2() {
        try {
            FileInputStream fin = new FileInputStream("./object_test02");
            ObjectInputStream objIn = new ObjectInputStream(fin);
            ArrayList<F_Person> people = (ArrayList<F_Person>) objIn.readObject();
            for(int i = 0; i < people.size(); i++) {
                System.out.println(people.get(i));
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void serialization2(){
        ArrayList<F_Person> persons = new ArrayList<>();
        persons.add(new F_Person("Steve",100));
        persons.add(new F_Person("Tom",12));
        try {
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("./object_test02"));
            objOut.writeObject(persons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deserialization() {
        try {
            FileInputStream fin = new FileInputStream("./object_test");
            ObjectInputStream objIn = new ObjectInputStream(fin);
            F_Person person1 = (F_Person) objIn.readObject();
            System.out.println(person1);
            F_Person person2 = (F_Person) objIn.readObject();
            System.out.println(person2);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void serialization(){
        F_Person steve = new F_Person("Steve",100);
        F_Person tom = new F_Person("Tom",12);
        try {
            FileOutputStream fout = new FileOutputStream("./object_test01");
            ObjectOutputStream objOut = new ObjectOutputStream(fout);
            //직렬화 역직렬화는 실행해보기 전에 에러가 안남
            objOut.writeObject(steve);
            objOut.writeObject(tom);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void loadObject2(){
        try {
            DataInputStream din = new DataInputStream(new FileInputStream("./object_test01"));

            int number;
            String name;

            number = din.readInt();
            name = din.readUTF();
            F_Person person1 = new F_Person(name,number);

            number = din.readInt();
            name = din.readUTF();
            F_Person person2 = new F_Person(name,number);

            System.out.println(person1.getName()+" "+person1.getNumber());
            System.out.println(person2.getName()+" "+person2.getNumber());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void loadObject(){
        try {
            FileInputStream fin = new FileInputStream("./object_test");
            byte[] data = fin.readNBytes(4);
            System.out.println(Arrays.toString(data));
            //byte를 int형으로 바꿔줌
            System.out.println(ByteBuffer.wrap(data).getInt());
            //byte[] name = fin.readNBytes(4);
            byte[] name2 = new byte[30];
            fin.read(name2,0,10);
            System.out.println(Arrays.toString(name2));
            System.out.println(new String(name2));
            /*
            System.out.println(Arrays.toString(name));
            System.out.println(new String(name));

             */
            //문자열 길이를 알 수 없기 떄문에 값을 받기 힘듦
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void saveObject(){
        F_Person tom = new F_Person("tom",56);
        F_Person steve = new F_Person("steve",95);
        try {
            FileOutputStream fout = new FileOutputStream("./object_test");
            //dataoutputstream 프리미티브타입? 사용가능..?
            //                 close()없음 자동으로 닫힘
            DataOutputStream dout = new DataOutputStream(fout);
            //얼어디질것같닫..
            dout.writeInt(steve.getNumber());
            dout.writeUTF(steve.getName());
            dout.writeInt(tom.getNumber());
            dout.writeUTF(tom.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
