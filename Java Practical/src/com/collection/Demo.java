package com.collection;

import java.util.*;

public class Demo
{
    public static void main(String[] args)
    {
        demoTreeSet();
    }

    public static void testList()
    {
        Student s1 = new Student("马拉杰", 24);
        Student s2 = new Student("迪丽热巴", 28);

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);

        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext())
        {
            Student s = iterator.next();
            s.show();
        }
        System.out.println("-------------------");

        for (int i = 0; i < list.size(); i++)
        {
            Student s = list.get(i);
            s.show();
        }
        System.out.println("-------------------");

        for (Student s : list)
        {
            s.show();
        }

    }

    public static void testArrayList()
    {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("ma");
        arr.add("la");
        arr.add("jie");

        for (String s : arr)
        {
            System.out.println(s);
        }

        System.out.println("------------------");

        for (int i = 0; i < arr.size(); i++)
        {
            String s = arr.get(i);
            System.out.println(s);
        }

        System.out.println("-------------------");

        Iterator<String> it = arr.iterator();
        while (it.hasNext())
        {
            String s = it.next();
            System.out.println(s);
        }

    }

    public static void testLinkedList()
    {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("ma");
        linkedList.add("la");
        linkedList.add("jie");

        for (String s : linkedList)
        {
            System.out.println(s);
        }

    }

    public static void demoArrayList()
    {
        Student s1 = new Student("马拉杰", 24);
        Student s2 = new Student("迪丽热巴", 28);

        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(s1);
        arrayList.add(s2);

        Iterator<Student> iterator = arrayList.iterator();
        while (iterator.hasNext())
        {
            Student s = iterator.next();
            s.show();
        }
        System.out.println("-------------------");

        for (int i = 0; i < arrayList.size(); i++)
        {
            Student s = arrayList.get(i);
            s.show();
        }
        System.out.println("-------------------");

        for (Student s : arrayList)
        {
            s.show();
        }
    }

    public static void demoHashSet()
    {
    }

    public static void demoTreeSet()
    {
        TreeSet<Student> ts = new TreeSet<>(new Comparator<>()
        {
            @Override
            public int compare(Student s1, Student s2)
            {
                int num = s2.getSum() - s1.getSum();
                int num2 = num==0?s2.getChinese()-s1.getChinese():num;
                int num3 = num2 ==0?s1.getName().compareTo(s2.getName()):num2;
                return num3;
            }
        });

        Student s1 = new Student("迪",24,95,99,100);
        Student s2 = new Student("丽",25,94,98,100);
        Student s3 = new Student("热",26,93,97,100);
        Student s4 = new Student("巴",27,92,96,100);
        Student s5 = new Student("迪丽热巴",28,100,100,100);
        Student s6 = new Student("ma",27,90,98,100);
        Student s7 = new Student("la",27,90,98,100);


        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);
        ts.add(s7);

        for (Student s: ts){
            s.show();
        }


    }


}
