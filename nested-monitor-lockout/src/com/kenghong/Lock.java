package com.kenghong;

class MonitorObject {

}

public class Lock {

    protected MonitorObject monitorObject = new MonitorObject();
    protected boolean isLocked = false;

    public void lock() throws InterruptedException {
        synchronized(this) {
            while(isLocked) {
                synchronized (monitorObject) {
                    monitorObject.wait();
                }
            }
            isLocked = true;
        }
    }

    public void unlock() {
        synchronized (this) {
            isLocked = false;
            synchronized (monitorObject) {
                monitorObject.notify();
            }
        }
    }
}
