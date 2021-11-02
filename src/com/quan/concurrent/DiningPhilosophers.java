package com.quan.concurrent;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
//    private Semaphore[] locks;
    private Semaphore lock;

    public DiningPhilosophers() {
//        locks = new Semaphore[]{
//                new Semaphore(1),
//                new Semaphore(0),
//                new Semaphore(0),
//                new Semaphore(0),
//                new Semaphore(0)
//        };
        lock = new Semaphore(1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        // 一个个吃
        lock.acquire(1);
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        lock.release(1);
    }
}
