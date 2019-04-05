package com.kenghong;

public class SimpleThread extends Thread {

    public SimpleThread(String name) {
        super(name);
    }

    public void run() {

        System.out.println(getName() + " running...");
        try {
            sleep(3L * 1000L); // Thread sleeps for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
