package taskOne;

public class MessageThread implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("5 seconds have passed");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
