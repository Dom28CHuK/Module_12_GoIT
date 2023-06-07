package multithreadingDemo;

public class ChieldThread extends Thread {

    @Override
    public void run() {
        System.out.println("done " + Thread.currentThread().getName());
    }
}
