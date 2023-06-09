import taskOne.MessageThread;
import taskOne.TimeThread;

public class Main {
    public static void main(String[] args) {
        Thread timerThread = new Thread(new TimeThread());
        Thread messageThread = new Thread(new MessageThread());
        timerThread.start();
        messageThread.start();
    }
}
