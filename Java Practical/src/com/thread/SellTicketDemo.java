package com.thread;

public class SellTicketDemo
{
    public static void main(String[] args)
    {
        SellTicket st = new SellTicket();

        Thread t1 = new Thread(st,"1");
        Thread t2 = new Thread(st,"2");
        Thread t3 = new Thread(st,"3");
        Thread t4 = new Thread(st,"4");
        Thread t5 = new Thread(st,"5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
