package com.kenghong;

public class Main {

    public static void main(String[] args) {

        // shared instance variable
        Counter counter = new Counter();
        // access to shared counter is synchronized (restricted to one thread at a time)
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        // READ and WRITE are performed atomically
        AtomicCounter atomicCounter = new AtomicCounter();

        Thread t1 = new Thread(counter, "Thread - t1");
        Thread t2 = new Thread(counter, "Thread - t2");
        Thread t3 = new Thread(counter, "Thread - t3");
        Thread t4 = new Thread(synchronizedCounter, "Thread - t4");
        Thread t5 = new Thread(synchronizedCounter, "Thread - t5");
        Thread t6 = new Thread(synchronizedCounter, "Thread - t6");
        Thread t7 = new Thread(atomicCounter, "Thread - t7");
        Thread t8 = new Thread(atomicCounter, "Thread - t8");
        Thread t9 = new Thread(atomicCounter, "Thread - t9");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();

        try {
            Thread.sleep(1000L);
            System.out.println(counter.getCount());
            System.out.println(synchronizedCounter.getCount());
            System.out.println(atomicCounter.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
