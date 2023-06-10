package taskTwo;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class FizzBuzzThreads {
    private int n;
    private BlockingDeque<String> queue;

    public FizzBuzzThreads(int n) {
        this.n = n;
        this.queue = new LinkedBlockingDeque<>();
    }

    public void fizzBuzz() throws InterruptedException {
        Thread threadFizz = new Thread(() -> {
            try {
                for (int i = 3; i <= n; i += 3) {
                    if (i % 5 != 0) {
                        queue.put("fizz");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadBuzz = new Thread(() -> {
            try {
                for (int i = 5; i <= n; i += 5) {
                    if (i % 3 != 0) {
                        queue.put("buzz");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


}
