package com.kenghong;

public class Example1 {

    private Lock lock = new Lock();

    private Thread t0 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " has been locked.");
                Thread.sleep(1000L);
                System.out.println("Unblocking taking place soon for " + Thread.currentThread().getName());
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    private Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " has been locked.");
                Thread.sleep(1000L);
                System.out.println("Unblocking taking place soon for " + Thread.currentThread().getName());
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    public void execute() {
        t0.start();
        t1.start();
    }
}
