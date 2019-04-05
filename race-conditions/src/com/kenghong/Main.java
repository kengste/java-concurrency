package com.kenghong;

public class Main {

    public static void main(String[] args) {

        // shared instance variable
        Counter counter = new Counter();
        // access to shared counter is synchronized (restricted to one thread at a time)
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        Thread t1 = new Thread(counter, "Thread - t1");
        Thread t2 = new Thread(counter, "Thread - t2");
        Thread t3 = new Thread(counter, "Thread - t3");
        Thread t4 = new Thread(synchronizedCounter, "Thread - t4");
        Thread t5 = new Thread(synchronizedCounter, "Thread - t5");
        Thread t6 = new Thread(synchronizedCounter, "Thread - t6");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        try {
            Thread.sleep(1000L);
            System.out.println(counter.getCount());
            System.out.println(synchronizedCounter.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
