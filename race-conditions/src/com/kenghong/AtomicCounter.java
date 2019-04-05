package com.kenghong;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter implements Runnable {

    protected AtomicLong count = new AtomicLong();

    public void increase() {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.getAndIncrement();
    }

    public void decrease() {
        count.getAndDecrement();
    }

    public long getCount() {
        return count.get();
    }

    public void run() {
        increase();
        System.out.println("Value for thread after increase " + Thread.currentThread().getName() + " " + getCount());
        decrease();
        System.out.println("Value for thread after decrease " + Thread.currentThread().getName() + " " + getCount());
    }
}