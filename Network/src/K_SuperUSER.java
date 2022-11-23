import java.io.Serializable;

/**
 * Nomal, Guest 를 만들었을 때
 * 다 implements를 해줘야 함
 * 100개의 user type을 만들면 100번 직렬화해야 함
 *
 * >> super class에서 직렬화를 해주면
 * 하위 class도 다 직렬화 해준다
 *
 * 모든 class의 상위 = object class
 * object class는 직렬화가 안된다
 * object type은 불가능
 * ex) Object user; (X)
 *
 *
 */
public class K_SuperUSER extends K_USER
{
    private int level;

    public K_SuperUSER(String name, String passwd, long id, int level) {
        super(name, passwd, id);
        this.level = level;
    }
}
