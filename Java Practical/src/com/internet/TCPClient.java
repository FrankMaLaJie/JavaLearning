package com.internet;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient
{
    public static void main(String[] args) throws IOException
    {

        clientTest6();
    }

    public static void send() throws IOException
    {
        //创建客户端的Socket对象（Socket）
        Socket s = new Socket(InetAddress.getByName("192.168.0.139"), 12345);

        //获取输出流，写数据
        OutputStream os = s.getOutputStream();
        os.write("hello,tcp,我来了".getBytes());

        //释放资源
        os.close();
    }

    public static void clientTest1() throws IOException
    {
        //创建客户端的Socket对象（Socket）
        Socket s = new Socket("192.168.0.139", 12345);

        //获取输出流，写数据
        OutputStream os = s.getOutputStream();
        os.write("tcp,test1".getBytes());

        //接收服务器反馈
        InputStream is = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        String data = new String(bytes, 0, len);
        System.out.println("客户端：" + data);

        //释放资源
        s.close();
    }

    public static void clientTest2() throws IOException
    {
        //- 创建客户端的Socket对象（Socket）
        Socket s = new Socket("192.168.0.139", 12345);

        //数据来自于键盘录入，直到输入的数据是886，发送数据结束
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null)
        {
            if (line.equals("886"))
            {
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();

        }
        //- 释放资源
        s.close();
    }

    public static void clientTest3() throws IOException
    {
        //- 创建客户端的Socket对象（Socket）
        Socket s = new Socket("192.168.0.139", 12345);

        //数据来自于键盘录入，直到输入的数据是886，发送数据结束
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null)
        {
            if (line.equals("886"))
            {
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //- 释放资源
        s.close();
    }

    public static void clientTest4() throws IOException
    {
        //- 创建客户端的Socket对象（Socket）
        Socket s = new Socket("192.168.0.139", 12345);

        //数据来自于文本文件，封装文本文件数据
        BufferedReader br = new BufferedReader
                (new FileReader("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\成绩排序.txt"));

        //封装输出流写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null)
        {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //- 释放资源
        br.close();
        s.close();
    }

    public static void clientTest5() throws IOException
    {
        //- 创建客户端的Socket对象（Socket）
        Socket s = new Socket("192.168.0.139", 12345);

        //数据来自于文本文件，封装文本文件数据
        BufferedReader br = new BufferedReader
                (new FileReader("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\成绩排序.txt"));

        //封装输出流写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null)
        {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //自定义结束标记
//        bw.write("886");
//        bw.newLine();
//        bw.flush();
        s.shutdownOutput();

        //接收反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = brClient.readLine();//等待读取数据
        System.out.println("服务器的反馈" + data);

        //- 释放资源
        br.close();
        s.close();
    }

    public static void clientTest6() throws IOException
    {
        //- 创建客户端的Socket对象（Socket）
        Socket s = new Socket("192.168.0.139", 12345);

        //数据来自于文本文件，封装文本文件数据
        BufferedReader br = new BufferedReader
                (new FileReader("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\成绩排序.txt"));

        //封装输出流写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null)
        {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        s.shutdownOutput();

        //接收反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = brClient.readLine();//等待读取数据
        System.out.println("服务器的反馈" + data);

        //- 释放资源
        br.close();
        s.close();
    }
}
