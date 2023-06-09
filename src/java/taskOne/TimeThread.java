package taskOne;

import java.time.Duration;
import java.time.Instant;

public class TimeThread implements Runnable{
    @Override
    public void run() {
        Instant startTime = Instant.now();

        while (true) {
            Instant currentTime = Instant.now();
            Duration elapsedTime = Duration.between(startTime, currentTime);

            System.out.println("Time has passed: " + elapsedTime.getSeconds() + " seconds");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
