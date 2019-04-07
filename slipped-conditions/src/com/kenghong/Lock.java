package com.kenghong;

public class Lock {

    private boolean isLocked = false;

    public void lock() {
        synchronized(this){
            while(isLocked){
                try{
                    wait();
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        synchronized(this){
            isLocked = true;
        }
    }

    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
