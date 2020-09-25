package com.iostream;

import com.studentmanager.Student;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Put;
import org.apache.commons.math3.analysis.function.Add;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        video();
    }

    public static void video() throws IOException
    {
        BufferedReader br = new BufferedReader
                (new FileReader("C:\\Users\\Frank\\Desktop\\ffmpeg-files.txt"));
        BufferedWriter bw = new BufferedWriter
                (new FileWriter("C:\\Users\\Frank\\Desktop\\ffmpeg-files(1).txt"));

        String line;
        while ((line = br.readLine()) != null)
        {
            String s = line.split(" ")[3];
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static void myLoad() throws IOException
    {
        Properties prop = new Properties();

        FileReader fr = new FileReader("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\prop.txt");
        prop.load(fr);
        fr.close();

        System.out.println(prop);
    }

    private static void myStore() throws IOException
    {
        Properties prop = new Properties();

        prop.setProperty("123", "456");
        prop.setProperty("789", "123");
        prop.setProperty("456", "789");

        //void store(Writer writer, String comments)
        FileWriter fw = new FileWriter("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\prop.txt");
        prop.store(fw, null);

        fw.close();
    }


    public static void uniqueProp()
    {
        Properties prop = new Properties();

        prop.setProperty("123", "456");
        prop.setProperty("789", "123");
        prop.setProperty("456", "789");

        Set<String> names = prop.stringPropertyNames();

        for (String key : names)
        {
            String value = prop.getProperty(key);
            System.out.println(key + value);
        }
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

    public static void studentArrToFile() throws IOException
    {

        //创建ArrayList集合
        ArrayList<Student> arr = new ArrayList<>();

        //创建学生对象
        Student s1 = new Student("001", "malajie", "24", "Dongguan");
        Student s2 = new Student("002", "dilireba", "28", "Xinjiang");
        Student s3 = new Student("003", "pikachu", "5", "Nintendo");
        Student s4 = new Student("004", "link", "100", "Hyrule");
        Student s5 = new Student("005", "zelda", "100", "Hyrule");

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
        for (Student s : arr)
        {

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

    public static void fileToStudentArr() throws IOException
    {

        //创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\字符串.txt")
        );

        //创建ArrayList集合
        ArrayList<Student> arr = new ArrayList<>();

        //调用字符缓冲输入流对象的方法读数据
        //001, malajie, 24, Dongguan
        String line;
        while ((line = br.readLine()) != null)
        {

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
        for (Student s : arr)
        {
            System.out.println(s);
        }
    }

    public static void studentArrToFile2() throws IOException
    {

        TreeSet<com.collection.Student> ts = new TreeSet<>(new Comparator<com.collection.Student>()
        {
            //创建TreeSet集合，通过比较器排序
            @Override
            public int compare(com.collection.Student s1, com.collection.Student s2)
            {
                //总分从高到低，后一个减去前一个
                int num = s2.getSum() - s1.getSum();
                int num2 = num == 0 ? s1.getChinese() - s2.getChinese() : num;
                int num3 = num2 == 0 ? s1.getMath() - s2.getMath() : num2;
                int num4 = num3 == 0 ? s1.getName().compareTo(s2.getName()) : num3;
                return num4;
            }
        });

        //键盘录入学生数据
        for (int i = 0; i < 5; i++)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入第" + (i + 1) + "个学生的学生信息");

            System.out.println("姓名：");
            String name = sc.nextLine();
            System.out.println("年龄：");
            int age = sc.nextInt();
            System.out.println("语文成绩：");
            int chinese = sc.nextInt();
            System.out.println("数学成绩：");
            int math = sc.nextInt();
            System.out.println("英语成绩：");
            int english = sc.nextInt();

            //创建学生对象，把键盘录入的数据赋值给对应的学生对象的成员变量
            com.collection.Student s = new com.collection.Student();
            s.setName(name);
            s.setAge(age);
            s.setChinese(chinese);
            s.setMath(math);
            s.setEnglish(english);

            //把学生对象添加TreeSet集合中
            ts.add(s);
        }

        //创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\成绩排序.txt"));

        //遍历集合，得到每一个学生对象
        for (com.collection.Student s : ts)
        {
            //把学生对象的数据拼接成指定格式的字符串
            StringBuilder sb = new StringBuilder();
            sb.append(s.getName()).append(", ")
                    .append(s.getAge()).append(", ")
                    .append(s.getChinese()).append(", ")
                    .append(s.getMath()).append(", ")
                    .append(s.getEnglish()).append(", ")
                    .append(s.getSum());

            //调用字符缓冲输出流对象的方法写数据
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
    }

    public static void copyFolderDemo() throws IOException
    {
        //创建数据源目录File对象，路径是F:\招聘
        File srcFolder = new File("F:\\招聘");

        //获取数据源目录File对象的名称（招聘）
        String srcFolderName = srcFolder.getName();

        //创建目的地目录File对象，路径名是F:\游戏课程
        File destFolder = new File("F:\\游戏课程", srcFolderName);

        //判断目的地目录对应的File是否存在，如果不存在就创建
        if (!destFolder.exists())
        {
            destFolder.mkdir();
        }

        //获取数据源目录下所有文件的File数组
        File[] listFiles = srcFolder.listFiles();

        //遍历数组，得到每一个File对象，该File对象就是数据源文件
        //数据源文件：F:\招聘\简历修改注意事项.docx
        for (File srcFile : listFiles)
        {

            //获取数据源文件File对象的名称（简历修改注意事项.docx）
            String srcFileName = srcFile.getName();

            //创建目的地文件File对象，路径名是目的地目录+简历修改注意事项.docx（F:\游戏课程\简历修改注意事项.docx）
            File destFile = new File(destFolder, srcFileName);

            //复制文件
            copyFile(srcFile, destFile);
        }

    }

    public static void copyFoldersDemo() throws IOException
    {
        //创建数据源目录File对象，路径是F:\文明大家庭成员综合考核评比
        File srcFile = new File("F:\\文明大家庭成员综合考核评比");

        //创建目的地目录File对象，路径名是G:\
        File destFile = new File("G:\\");

        //写方法实现文件夹的复制，参数为数据源File对象和目的地File对象
        copyFolder(srcFile, destFile);
    }

    private static void copyFolder(File srcFile, File destFile) throws IOException
    {
        //判断传入进来的数据源File是否是目录
        if (srcFile.isDirectory())
        {
            //如果是目录的话，在目的地下创建和传入的数据源File名称一样的目录
            String srcFileName = srcFile.getName();
            File newFolder = new File(destFile, srcFileName);//G:\文明大家庭成员综合考核评比

            //判断目的地是否存在，如果不存在，就创建
            if (!newFolder.exists())
            {
                newFolder.mkdir();
            }

            //获取数据源目录下所有文件或者目录的File数组
            File[] listFiles = srcFile.listFiles();

            //遍历数组，得到每一个File对象
            for (File file : listFiles)
            {
                //把该File对象作为数据源对象，递归调用复制文件夹的方法
                copyFolder(file, newFolder);
            }
        }
        else
        {
            //如果不是目录，那就是文件，直接调用字节流复制文件方法
            //要先创建目的地目录下的目的地文件
            File newFile = new File(destFile, srcFile.getName());
            copyFile(srcFile, newFile);
        }
    }

    private static void copyFile(File srcFile, File destFile) throws IOException
    {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1)
        {
            bos.write(bytes, 0, len);
        }
        bis.close();
        bos.close();
    }

    public static void serializable() throws IOException
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("123"));
        Student s = new Student();
        oos.writeObject(s);

    }
}
