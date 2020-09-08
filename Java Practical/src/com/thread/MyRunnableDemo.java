package com.thread;

public class MyRunnableDemo
{
    public static void main(String[] args)
    {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr, "123");
        Thread t2 = new Thread(mr, "456");

        t1.start();
        t2.start();
    }
}
