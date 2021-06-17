package testall;

import java.util.concurrent.Phaser;

public class LongRunningAction implements Runnable {
    private String threadName;
    private Phaser ph;

    public LongRunningAction(String threadName, Phaser ph) {
        this.threadName = threadName;
        this.ph = ph;
        ph.register();
    }

    @Override
    public void run() {
        ph.arriveAndAwaitAdvance();
        System.out.println("Inside thread: " + threadName);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ph.arriveAndDeregister();
    }
}
