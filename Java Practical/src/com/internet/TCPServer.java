package com.internet;

import java.io.*;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer
{
    public static void main(String[] args) throws IOException
    {
        serverTest6();
    }

    public static void receive() throws IOException
    {
        //- 创建服务端的Socket对象（ServerSocket）
        ServerSocket ss = new ServerSocket(12345);

        //- 获取输入流，读数据，把数据显示在控制台
        //要先监听Socket对象，真听到连接到此套接字并接收它
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        byte[] bytes = new byte[1024];
        int length = is.read(bytes);
        String data = new String(bytes, 0, length);
        System.out.println("数据是：" + data);

        //- 释放资源
        s.close();
        ss.close();
    }

    public static void serverTest1() throws IOException
    {
        //- 创建服务端的Socket对象（ServerSocket）
        ServerSocket ss = new ServerSocket(12345);

        //- 监听客户端连接，返回一个Socket对象
        Socket s = ss.accept();

        //- 获取输入流，读数据，把数据显示在控制台
        InputStream is = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        String data = new String(bytes, 0, len);
        System.out.println("服务器：" + data);

        //给出反馈
        OutputStream os = s.getOutputStream();
        os.write("数据已经收到".getBytes());

        //- 释放资源
        ss.close();
    }

    public static void serverTest2() throws IOException
    {
        //- 创建服务端的Socket对象（ServerSocket）
        ServerSocket ss = new ServerSocket(12345);

        //- 监听客户端连接，返回一个Socket对象
        Socket s = ss.accept();

        //- 获取输入流，读数据，把数据显示在控制台
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line = br.readLine()) != null)
        {
            System.out.println(line);
        }
        //释放资源
        ss.close();
    }

    public static void serverTest3() throws IOException
    {
        //创建服务器Socket对象
        ServerSocket ss = new ServerSocket(12345);

        //- 监听客户端连接，返回一个Socket对象
        Socket s = ss.accept();

        //- 读数据，
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //把数据写入文本文件
        BufferedWriter bw = new BufferedWriter(new FileWriter
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\internet\\TCPtest3.txt"));
        String line;
        while ((line = br.readLine()) != null)
        {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        ss.close();
        bw.close();
    }

    public static void serverTest4() throws IOException
    {
        //创建服务器Socket对象
        ServerSocket ss = new ServerSocket(12345);

        //- 监听客户端连接，返回一个Socket对象
        Socket s = ss.accept();

        //- 读数据，
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //把数据写入文本文件
        BufferedWriter bw = new BufferedWriter(new FileWriter
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\internet\\TCPtest4.txt"));
        String line;
        while ((line = br.readLine()) != null)
        {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        ss.close();
        bw.close();
    }

    public static void serverTest5() throws IOException
    {
        //创建服务器Socket对象
        ServerSocket ss = new ServerSocket(12345);

        //- 监听客户端连接，返回一个Socket对象
        Socket s = ss.accept();

        //- 读数据，
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //把数据写入文本文件
        BufferedWriter bw = new BufferedWriter(new FileWriter
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\internet\\TCPtest4.txt"));
        String line;
        while ((line = br.readLine()) != null)
        {
//            if ("886".equals(line))
//            {
//                break;
//            }
            //等待读取数据
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //给出反馈
        BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bwServer.write("文件上传成功");
        bwServer.newLine();
        bwServer.flush();

        //释放资源
        ss.close();
        bw.close();
        bwServer.close();
    }

    public static void serverTest6() throws IOException
    {
        //创建服务器Socket对象
        ServerSocket ss = new ServerSocket(12345);


        while (true)
        {
            //- 监听客户端连接，返回一个Socket对象
            Socket s = ss.accept();
            //为每一个客户端开启一个线程
            new Thread(new ServerThread(s)).start();
        }
    }
}
