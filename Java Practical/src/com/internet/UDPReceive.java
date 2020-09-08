package com.internet;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive
{
    public static void main(String[] args) throws IOException
    {
        untill886();
    }

    public static void learn() throws IOException
    {
        //- 创建发送端的Socket对象（`DatagramSocket`）
        DatagramSocket ds = new DatagramSocket(10086);

        //- 创建数据包，用于接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

        //- 调用`DatagramSocket`对象的方法接收数据
        ds.receive(dp);

        //- 解析数据包，并把数据在控制台显示
        byte[] data = dp.getData();
        int length = dp.getLength();
        String dataString = new String(data,0,length);
        System.out.println("数据是:" + dataString);

        //- 关闭发送端
        ds.close();
    }

    public static void untill886() throws IOException{
        DatagramSocket ds = new DatagramSocket(12345);

        while (true)
        {
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

            ds.receive(dp);

            System.out.println("数据是：" + new String(dp.getData(), 0, dp.getLength()));
        }
    }
}
