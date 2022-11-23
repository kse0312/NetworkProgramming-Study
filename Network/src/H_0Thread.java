/**
 * Thread Class 상속
 * 순서는 보장할 수 없음
 * primitive 를 통해 우선순위를 올릴 수는 있지만
 * 다 똑같이 올리기 때문에 크게 달라지는건 없음
 */
public class H_0Thread extends Thread{
    public H_0Thread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 10; i > -1; i--) {
            System.out.println(getName()+":"+i);
            try {
                //sleep은 try/catch 필수
                //실행 도중 깨울 수 있어야 함
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
