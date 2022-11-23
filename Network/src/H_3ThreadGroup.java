public class H_3ThreadGroup {
    public static void main(String[] args) {
        ThreadGroup timer = new ThreadGroup("Timer");

        ThreadGroup suwon = new ThreadGroup(timer,"suwon Timer");
        ThreadGroup jeju = new ThreadGroup(timer,"jeju Timer");
        jeju.setMaxPriority(1);
        suwon.setMaxPriority(10);
        Thread suwoncountdown = new Thread(timer,new H_1Thread(),"Suwon Timer");
        Thread jejucountdown = new Thread(timer,new H_1Thread(),"Jeju Timer");
        suwoncountdown.start();
        try {
            suwoncountdown.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        jejucountdown.start();
        //Deamon 죽는 기준 -> 본인의 Thread가 죽으면 같이 사망
        try {
            Thread notithread = new Thread(new H_4Notification());
            notithread.setDaemon(true);
            notithread.start();
            Thread.sleep(10*1000);
            System.out.println("Current Thread: "+ Thread.currentThread().getName());
            System.out.println("Deamon?"+notithread.isDaemon());
            System.out.println("Main Thread End!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
