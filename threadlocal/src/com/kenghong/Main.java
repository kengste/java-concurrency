package com.kenghong;

public class Main {

    public static void main(String[] args) {
        CustomRunnable sharedRunnableInstance = new CustomRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); //wait for thread 1 to terminate
            thread2.join(); //wait for thread 2 to terminate
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
