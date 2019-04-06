package com.kenghong;

class MonitorObject {}

public class WaitNotify {

    MonitorObject monitorObject = new MonitorObject();
    boolean wasSignaled = false;

    public void doWait(){
        synchronized(monitorObject){
            while(!wasSignaled) {
                try{
                    monitorObject.wait();
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            wasSignaled = false;
        }
    }

    public void doNotify(){
        synchronized(monitorObject){
            wasSignaled = true;
//            monitorObject.notify();
            monitorObject.notifyAll();
        }
    }
}
