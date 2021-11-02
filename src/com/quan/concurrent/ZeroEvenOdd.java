package com.quan.concurrent;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private volatile int flag = 0;
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while ((flag & 1) == 1) {
                Thread.yield();
            }
            printNumber.accept(0);
            flag++;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <=n ; i += 2) {
            while (flag % 4 != 3) {
                Thread.yield();
            }
            printNumber.accept(i );
            flag++;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <=n; i += 2) {
            while (flag % 4 != 1) {
                Thread.yield();
            }
            printNumber.accept(i );
            flag++;
        }
    }
}
