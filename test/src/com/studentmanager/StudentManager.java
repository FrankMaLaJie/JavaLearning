package com.studentmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager
{
    public static void main(String[] args)
    {
        //创建集合用于存放学生对象
        ArrayList<Student> arrayList = new ArrayList<>();

        //用循环再次回到主界面
        while (true)
        {
            //主界面
            System.out.println("----------欢迎来到学生管理系统----------");
            System.out.println("1、添加学生信息");
            System.out.println("2、删除学生信息");
            System.out.println("3、修改学生信息");
            System.out.println("4、查看所有学生信息");
            System.out.println("5、退出");
            System.out.println("请输入你的选择：");

            //Scanner实现键盘录入
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            switch (line)
            {
                case "1" -> addStudent(arrayList);
                case "2" -> deleteStudent(arrayList);
                case "3" -> updateStudent(arrayList);
                case "4" -> findAllStudent(arrayList);
                case "5" -> {
                    System.out.println("感谢使用");
                    System.exit(0);//JVM退出
                }
            }
        }
    }

    public static void addStudent(ArrayList<Student> arrayList)
    {
        Scanner scanner = new Scanner(System.in);
        String sid;

        //让程序回到这里，用循环实现
        while (true)
        {
            //录入学生信息
            System.out.println("请输入学生的学号：");
            sid = scanner.nextLine();

            //判断学号是否重复
            boolean flag = isUsed(arrayList, sid);
            if (flag)
            {
                System.out.println("输入学号已经被使用，请重新输入");
            }
            else
            {
                break;
            }
        }
        System.out.println("请输入学生的名字：");
        String name = scanner.nextLine();
        System.out.println("请输入学生的年龄：");
        String age = scanner.nextLine();
        System.out.println("请输入学生的地址：");
        String address = scanner.nextLine();

        //创建学生对象，把信息赋值给成员变量
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        //添加到集合中
        arrayList.add(s);

        //给出添加成功的提示
        System.out.println("添加成功");
    }

    public static void deleteStudent(ArrayList<Student> arrayList)
    {
        Scanner scanner = new Scanner(System.in);

        //键盘录入要删除的学生的学号
        String sid;

        while (true)
        {
            //录入学生信息
            System.out.println("请输入学生的学号：");
            sid = scanner.nextLine();

            //判断学号是否存在
            boolean flag = isUsed(arrayList, sid);
            if (flag)
            {
                break;
            }
            else
            {
                System.out.println("输入学号有误，请重新输入");
            }
        }

        for (int i = 0; i < arrayList.size(); i++)
        {
            Student s = arrayList.get(i);
            if (s.getSid().equals(sid)/*s.getSid() == sid*/)
            {
                arrayList.remove(i);
                System.out.println("删除学生成功");
                break;
            }
        }
    }

    public static void updateStudent(ArrayList<Student> arrayList)
    {
        //键盘录入要修改的学生的学号
        Scanner scanner = new Scanner(System.in);

        //创建对象
        Student s = new Student();
        String sid;

        //判断集合中是否有一个对象的学号和输入的相同
        //相同继续执行，不同重新输入
        while (true)
        {
            //录入学生信息
            System.out.println("请输入学生的学号：");
            sid = scanner.nextLine();

            //判断学号是否存在
            boolean flag = isUsed(arrayList, sid);
            if (flag)
            {
                break;
            }
            else
            {
                System.out.println("输入学号有误，请重新输入");
            }
        }

        //找出对应的对象进行修改
        for (int i = 0; i < arrayList.size(); i++)
        {
            s = arrayList.get(i);
            if (s.getSid().equals(sid)/*s.getSid() == sid*/)
            {
                //选择要修改的信息，case实现
                System.out.println("请选择要修改的信息");
                System.out.println("1、修改学生学号");
                System.out.println("2、修改学生姓名");
                System.out.println("3、修改学生年龄");
                System.out.println("4、修改学生居住地");
                String line = scanner.nextLine();

                switch (line)
                {
                    case "1":
                        System.out.println("请输入新的学生学号");
                        String newSid = scanner.nextLine();
                        s.setSid(newSid);
                        break;
                    case "2":
                        System.out.println("请输入新的学生姓名");
                        String newName = scanner.nextLine();
                        s.setName(newName);
                        break;
                    case "3":
                        System.out.println("请输入新的学生年龄");
                        String newAge = scanner.nextLine();
                        s.setAge(newAge);
                        break;
                    case "4":
                        System.out.println("请输入新的学生居住地");
                        String newAddress = scanner.nextLine();
                        s.setAddress(newAddress);
                        break;
                }

                //把修改好的数据放回集合中
                arrayList.set(i, s);
                System.out.println("修改成功");
                break;
            }
        }
    }

    public static void findAllStudent(ArrayList<Student> arrayList)
    {
        //判断集合中是否有数据，如果没有显示提示信息
        if (arrayList.size() == 0)
        {
            System.out.println("无信息，请先添加信息再查询");
            //为了不让程序继续往下执行
            return;
        }

        //显示表头信息，\t就是按下Tab进行缩进
        System.out.println("学号\t姓名\t年龄\t\t居住地");

        //将集合中的数据提取出来按照对应格式显示学生信息，年龄补充“岁”
        for (int i = 0; i < arrayList.size(); i++)
        {
            Student s = arrayList.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t\t" + s.getAddress());
        }
    }

    public static boolean isUsed(ArrayList<Student> arrayList, String sid)
    {
        boolean flag = false;

        for (int i = 0; i < arrayList.size(); i++)
        {
            Student s = arrayList.get(i);
            if (s.getSid().equals(sid))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
