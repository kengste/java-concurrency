package com.kenghong;

public class SimpleRunnable implements Runnable {

    private Boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop == false;
    }

    public void run() {
        while(keepRunning()) {
            System.out.println("Simple runnable running...");
        }
    }



}
