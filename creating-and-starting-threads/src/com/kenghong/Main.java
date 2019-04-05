package com.kenghong;

public class Main {

    public static void main(String[] args) {

        SimpleThread simpleThread = new SimpleThread("Simple thread");
        simpleThread.start();

        SimpleRunnable simpleRunnable = new SimpleRunnable();
        Thread simpleRunnableThread = new Thread(simpleRunnable, "Simple Runnable Thread");
        simpleRunnableThread.start();
        try {
            simpleRunnableThread.sleep(3L * 1000L);
            simpleRunnable.doStop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
