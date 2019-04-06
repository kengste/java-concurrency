package com.kenghong;

public class WaitNotifyExample {

    private static final WaitNotify waitNotify = new WaitNotify();

    private static Thread waitThread = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is preparing to wait...");
            waitNotify.doWait();
            System.out.println(Thread.currentThread().getName() + " is no longer waiting...");
        }
    });

    private static Thread waitThread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is preparing to wait...");
            waitNotify.doWait();
            System.out.println(Thread.currentThread().getName() + " is no longer waiting...");
        }
    });

    private static Thread notifyThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000L);
                waitNotify.doNotify();
                Thread.sleep(5000L);
                waitNotify.doNotify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    public static void execute() {
        waitThread.start();
        waitThread2.start();
        notifyThread.start();
    }
}
