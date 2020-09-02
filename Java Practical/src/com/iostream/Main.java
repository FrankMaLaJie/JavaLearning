package com.iostream;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {


    }

    public static void readByOne() throws IOException
    {
        //创建字节输出流对象
        FileInputStream fis = new FileInputStream("G:\\Github Desktop\\JavaLearning\\Java Practical\\fos.txt");

        int by;
        /*
            - fis.read()：读数据
            - by = fis.read()：把读到的数据赋值给by
            - by != -1：判断读取到的数据是否是-1
         */
        while ((by = fis.read()) != -1)
        {
            //把读取到的字节强制转换为字符
            System.out.println((char) by);
        }

        //最后一定要释放资源
        fis.close();
    }

    public static void write() throws IOException
    {
        //创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("G:\\Github Desktop\\JavaLearning\\Java Practical\\fos.txt");
        /*
            干了三件事情：
            - 调用系统功能创建了文件
            - 创建字节输出流对象
            - 让字节输出流对象指向文件
        */

        //写进去的不是"95"，而是"95"对应的字符
        fos.write(95);

        //最后一定要释放资源
        fos.close();
    }

    public static void copy() throws IOException
    {
        //根据数据源创建字节输入流对象
        FileInputStream fis = new FileInputStream
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\fos.txt");
        //根据目的地创建字节输出流对象
        FileOutputStream fos = new FileOutputStream
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\复制过来的.txt");

        int by;
        //读取数据，复制文件文本（一次读取一个字节，一次写入一个字节）
        while ((by = fis.read()) != -1)
        {
            fos.write(by);
        }

        //释放资源
        fis.close();
        fos.close();
    }

    public static void readByMore() throws IOException
    {
        //创建字节输出流对象
        FileInputStream fis = new FileInputStream("G:\\Github Desktop\\JavaLearning\\Java Practical\\fos.txt");//abcd

        //创建字节数组
        byte[] by = new byte[3];

        //读取最多字节数组长度（by.length()）个字符
        //此时by是空的，所以把文件中前三个字符的字节存入数组
        int len = fis.read(by);
        //返回实际读取到的个数
        System.out.println(len);//3
        //把从索引 0 到 len 的字节转换成字符串输出，
        System.out.println(new String(by, 0, len));//abc

        //此时，文件中只剩下d，所以拿d替换掉a，by里面最后存放了dbc
        len = fis.read(by);
        //返回实际读取到的个数
        System.out.println(len);//1
        System.out.println(new String(by, 0, len));//dbc

        //优化方案
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) != -1)
        {
            System.out.println(new String(bytes, 0, length));
        }

        //最后一定要释放资源
        fis.close();
    }

    public static void method1() throws IOException{
        //F:\学习视频\爬虫\day01.mp4
        //F:\学习视频

        FileInputStream fis = new FileInputStream("F:\\学习视频\\123\\day01.mp4");
        FileOutputStream fos = new FileOutputStream("F:\\学习视频");

        int by;

        while ((by = fis.read()) != -1){
            fos.write(by);
        }

        fis.close();
        fos.close();

    }

    public static void method2() throws IOException{
        FileInputStream fis = new FileInputStream("F:\\学习视频\\123\\day01.mp4");
        FileOutputStream fos = new FileOutputStream("F:\\学习视频");

        byte[] bytes = new byte[1024];
        int length;

        while ((length = fis.read(bytes)) != -1){
            fos.write(bytes, 0, length);
        }

        fis.close();
        fos.close();

    }
}
