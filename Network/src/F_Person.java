import java.io.Serializable;

/**
 * 22/10/04
 * ALT + INSERT 많이 쓰기
 */
public class F_Person extends F_Parent implements Serializable {
    //static : 공유 변수 / instance에 들어가지 않음 / 힙에 저장
    public static String type = "A";
    private String name;
    private int number;
    public F_Person(String home, String name, int number) {
        this.name = name;
        this.number = number;
    }
    public String toString() {
        return getName() + " : " + getNumber();
    }
    public F_Person(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public void hello(){
        System.out.println("I am " + name);
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        F_Person.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
