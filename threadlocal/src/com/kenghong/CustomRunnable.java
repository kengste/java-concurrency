package com.kenghong;

public class CustomRunnable implements Runnable {

    // Store Integer in Generic ThreadLocal instance
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public void run() {
        threadLocal.set((int)(Math.random() * 100D));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println(threadLocal.get());
    }
}
