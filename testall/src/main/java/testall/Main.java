package testall;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import static org.junit.Assert.assertEquals;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        Phaser ph = new Phaser(2);
//        assertEquals(0, ph.getPhase());

//        assertEquals(1, 3);

//        executorService.submit(new LongRunningAction("thread-1", ph));
//        executorService.submit(new LongRunningAction("thread-2", ph));
//        executorService.submit(new LongRunningAction("thread-3", ph));
//
//        System.out.println("Main thread; phase 1");
//        ph.arriveAndAwaitAdvance();
//        assertEquals(1, ph.getPhase());



//        executorService.submit(new LongRunningAction("thread-4", ph));
//        executorService.submit(new LongRunningAction("thread-5", ph));

//        System.out.println("Main thread; phase 2");
//        ph.arriveAndAwaitAdvance();
//        ph.arriveAndAwaitAdvance();

//        assertEquals(1, ph.getPhase());

//        ph.arriveAndDeregister();

//        new LongRunningAction("thread-4", ph).run();
//        new LongRunningAction("thread-5", ph).run();


//        ph.arriveAndAwaitAdvance();
//        ph.arriveAndAwaitAdvance();

        Phaser phaser = new Phaser();
        phaser.bulkRegister(3);
        executorService.submit(new Washer(phaser));
        executorService.submit(new Washer(phaser));

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Parent; phase " + i);
            phaser.arrive();
        }
    }

    static class Washer implements Runnable {
        Phaser phaser;

        public Washer(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                int currentPhase = phaser.arrive();
                System.out.println(Thread.currentThread().getName() + " washing the car on phase " + currentPhase);
                phaser.awaitAdvance(currentPhase);
            }
        }
    }
}
