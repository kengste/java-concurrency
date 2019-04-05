package com.kenghong;

public class SynchronizedCounter implements Runnable {

    protected long count = 0;

    public void increase() {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public void decrease() {
        count--;
    }

    public long getCount() {
        return count;
    }

    public synchronized void run() {
        increase();
        System.out.println("Value for thread after increase " + Thread.currentThread().getName() + " " + getCount());
        decrease();
        System.out.println("Value for thread after decrease " + Thread.currentThread().getName() + " " + getCount());
    }
}