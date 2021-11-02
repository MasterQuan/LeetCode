package com.quan.concurrent;

public class Foo {
    private volatile int flag = 1;
    public Foo() {
    }

    // printFirst.run() outputs "first". Do not change or remove this line.
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        flag = 2;
    }

    // printSecond.run() outputs "second". Do not change or remove this line.
    public void second(Runnable printSecond) throws InterruptedException {
        while (flag != 2);
        printSecond.run();
        flag = 3;
    }

    // printThird.run() outputs "third". Do not change or remove this line.
    public void third(Runnable printThird) throws InterruptedException {
        while (flag != 3);
        printThird.run();
    }
}
