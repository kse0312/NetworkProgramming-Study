import java.io.Serializable;

public class K_USER implements Serializable {
    /**
     * 내용이 바뀌면 직렬화 번호도 바뀌기 떄문에
     * 서버나 노드중 하나가 object class를 변경하면
     * 통신에 문제가 생긴다
     */
   // static final long serialVersionUID = -5129628467395047900L;
    private String name;
    private String passwd;
    private long id;

    public K_USER(String name, String passwd, long id) {
        this.name = name;
        this.passwd = passwd;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void Hello(){
        System.out.println("Hello"+name);
    }
    @Override
    public String toString() {
        return "K_USER{" +
                "name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", id=" + id +
                '}';
    }
}
