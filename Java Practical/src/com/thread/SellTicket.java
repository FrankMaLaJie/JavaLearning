package com.thread;

public class SellTicket implements Runnable
{
    private int tickets = 10000;
    private Object obj = new Object();

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+ "正在出售");
        while (true)
        {
            //tickets = 100
            //t1抢到CPU执行权
            //然后t2抢到CPU执行权，发现代码被锁起来了，只能执行完毕解锁后，才可以进入
            synchronized (obj)
            {
                //t1进来后就把代码锁起来
                if (tickets > 0)
                {
                    //通过sleep()方法模拟出票时间
                    try
                    {
                        //休息100毫秒
                        Thread.sleep(1);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println("出售成功，" +
                            Thread.currentThread().getName() + "窗口出售了第" + tickets + "张票");
                    tickets--;
                }
                //t1出来后，代码解锁
            }
        }
    }
}

