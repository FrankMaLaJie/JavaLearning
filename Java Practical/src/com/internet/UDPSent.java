package com.internet;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPSent
{
    public static void main(String[] args) throws IOException
    {
        untill886();
    }

    public static void learn() throws IOException
    {
        //创建发送端的Socket对象（`DatagramSocket`）
        DatagramSocket ds = new DatagramSocket();

        //创建数据，并且把数据打包
        byte[] bytes = "hello,udp,我来了".getBytes();
        DatagramPacket dp = new DatagramPacket
                (bytes, bytes.length, InetAddress.getByName("192.168.0.139"), 10086);

        //调用`DatagramSocket`对象的方法发送数据
        ds.send(dp);

        //关闭发送端
        ds.close();
    }

    public static void untill886() throws IOException
    {
        DatagramSocket ds = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        while (true)
        {
            String line = sc.nextLine();
            if (line.equals("886"))
            {
                break;
            }

            byte[] bytes = line.getBytes();

            DatagramPacket dp = new DatagramPacket
                    (bytes, bytes.length, InetAddress.getByName("192.168.0.139"), 12345);
            ds.send(dp);
        }

        ds.close();
    }
}
