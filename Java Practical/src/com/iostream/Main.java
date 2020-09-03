package com.iostream;

import com.studentmanager.Student;
import org.apache.commons.math3.analysis.function.Add;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        fileToStudentArr();
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

    public static void method1() throws IOException
    {
        //F:\学习视频\爬虫\day01.mp4
        //F:\学习视频

        FileInputStream fis = new FileInputStream("F:\\学习视频\\123\\day01.mp4");
        FileOutputStream fos = new FileOutputStream("F:\\学习视频");

        int by;

        while ((by = fis.read()) != -1)
        {
            fos.write(by);
        }

        fis.close();
        fos.close();

    }

    public static void method2() throws IOException
    {
        FileInputStream fis = new FileInputStream("F:\\学习视频\\123\\day01.mp4");
        FileOutputStream fos = new FileOutputStream("F:\\学习视频");

        byte[] bytes = new byte[1024];
        int length;

        while ((length = fis.read(bytes)) != -1)
        {
            fos.write(bytes, 0, length);
        }

        fis.close();
        fos.close();

    }

    public static void stringArrToFile() throws IOException
    {
        //创建ArrayList集合
        ArrayList<String> arr = new ArrayList<>();

        //向集合中存储字符串元素
        arr.add("ma");
        arr.add("la");
        arr.add("jie");

        //创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\字符串.txt")
        );

        //遍历集合，得到每一个字符串数据
        for (String s : arr)
        {
            //调用字符缓冲输出流对象的方法写数据
            bw.write(s);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
    }

    public static void fileToStringArr() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\字符串.txt"));

        ArrayList<String> arr = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null)
        {
            arr.add(line);
        }
        ;

        br.close();

        for (String s : arr)
        {
            System.out.println(s);
        }
    }

    public static void callName() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\字符串.txt")
        );

        ArrayList<String> arr = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null)
        {
            arr.add(line);
        }

        br.close();

        Random random = new Random();

        int index = random.nextInt(arr.size());

        String name = arr.get(index);

        System.out.println("幸运者是：" + name);
    }

    public static void studentArrToFile() throws IOException{

        //创建ArrayList集合
        ArrayList<Student> arr = new ArrayList<>();

        //创建学生对象
        Student s1 = new Student("001","malajie","24","Dongguan");
        Student s2 = new Student("002","dilireba","28","Xinjiang");
        Student s3 = new Student("003","pikachu","5","Nintendo");
        Student s4 = new Student("004","link","100","Hyrule");
        Student s5 = new Student("005","zelda","100","Hyrule");

        //把学生对象添加集合中
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        arr.add(s4);
        arr.add(s5);

        //创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter
                (new FileWriter("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\字符串.txt")
                );

        //遍历集合，得到每一个学生对象
        for (Student s : arr){

            StringBuilder sb = new StringBuilder();

            //把学生对象的数据拼接成指定格式的字符串
            sb.append(s.getSid()).append(", ").append(s.getName()).append(", ")
                    .append(s.getAge()).append(", ").append(s.getAddress());

            //调用字符缓冲输出流对象的方法写数据
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
    }

    public static void fileToStudentArr() throws IOException{

        //创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\字符串.txt")
        );

        //创建ArrayList集合
        ArrayList<Student> arr = new ArrayList<>();

        //调用字符缓冲输入流对象的方法读数据
        //001, malajie, 24, Dongguan
        String line;
        while ((line = br.readLine()) !=null){

            //把读取到的字符串数据用split()进行分割，得到一个字符串数组
            String[] str = line.split(", ");

            //创建学生对象
            Student s = new Student();

            //把字符串数组中的每一个元素取出来，赋值给对应的成员变量
            s.setSid(str[0]);
            s.setName(str[1]);
            s.setAge(str[2]);
            s.setAddress(str[3]);

            //把学生对象添加到集合
            arr.add(s);
        }

        //释放资源
        br.close();

        //遍历集合
        for(Student s :arr){
            System.out.println(s);
        }
    }
}
