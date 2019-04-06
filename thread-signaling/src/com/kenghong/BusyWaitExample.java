package com.kenghong;

public class BusyWaitExample {

    private final static CustomSignal customSignal = new CustomSignal();

    private static Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            while(!customSignal.hasDataToProcess()) {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
            }
        }
    });

    private static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customSignal.setHasDataToProcess(true);
        }
    });

    public static void execute() {
        t1.start();
        t2.start();
    }
}
