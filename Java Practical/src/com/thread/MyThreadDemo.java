package com.thread;

public class MyThreadDemo
{
    public static void main(String[] args)
    {
        MyTread mt1 = new MyTread();
        MyTread mt2 = new MyTread();

        mt1.start();
        mt2.start();

        System.out.println(Thread.currentThread().getName());
    }
}
