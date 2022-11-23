public class H_1Thread implements Runnable{
    @Override
    public void run() {
        for (int i = 10; i > -1; i--) {
            Thread currentthread = Thread.currentThread();
            System.out.println(currentthread.getName()+":"+i);
            System.out.println(currentthread.getThreadGroup());
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
