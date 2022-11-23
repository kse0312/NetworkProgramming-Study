import java.io.Serializable;

public class K_USER implements Serializable {

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

    @Override
    public String toString() {
        return "K_USER{" +
                "name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", id=" + id +
                '}';
    }
}
