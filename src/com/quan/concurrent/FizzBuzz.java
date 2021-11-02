package com.quan.concurrent;

import java.util.function.IntConsumer;

public class FizzBuzz {
    private volatile int i = 1;
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(i <= n) {
            if (i % 3 == 0 && i % 5 != 0) {
                printFizz.run();
                i++;
            }
            Thread.yield();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(i <= n) {
            if (i % 5 == 0 && i % 3 != 0) {
                printBuzz.run();
                i++;
            }
            Thread.yield();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i <= n) {
            if (i % 3 == 0 && i % 5 == 0) {
                printFizzBuzz.run();
                i++;
            }
            Thread.yield();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(i <= n) {
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                i++;
            }
            Thread.yield();
        }
    }
}
