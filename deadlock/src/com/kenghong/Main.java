package com.kenghong;

public class Main {

    public static void main(String[] args) {
        MyDeadlock mdl = new MyDeadlock();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}
