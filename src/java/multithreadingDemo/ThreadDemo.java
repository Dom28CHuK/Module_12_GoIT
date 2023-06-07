package multithreadingDemo;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread start " + Thread.currentThread().getName());
        Thread thread = new ChieldThread();
        thread.start();
//        Thread.currentThread().sleep(10);
        System.out.println("Main thread finish");

    }
}
