public class H_0TheadMain {
    public static void main(String[] args) {
        H_0Thread ex01 = new H_0Thread("T1");
        //Thread(Runnable target, String name)
        //interface도 다형성을 가지고 있다.
        //runnable 인터페이스로 구현한 객체만 넣어주면 됨.
        //이름 안주면 알아서 시스템이 name 부가함
        Thread ex04 = new Thread(new H_1Thread(),"a1");
        ex01.start();
        ex04.start();
        countDown("A1");
        countDown("B1");
    }
    public static  void countDown(String name){
        for (int i = 10; i > -1; i--) {
            System.out.println(name + ":" + i);
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

