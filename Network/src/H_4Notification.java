public class H_4Notification implements Runnable{
    @Override
    public void run() {
        while(true){
            int message = (int)(Math.random() * 10)+1;//1~10사이의 랜덤 변수
            try {
                System.out.println("Message Count: "+ message);
                Thread.sleep(2000);
            } catch (InterruptedException e) {  //Interrupted : 깨우는거
                throw new RuntimeException(e);
            }
        }

    }
}
