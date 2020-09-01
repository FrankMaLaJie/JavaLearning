package com.company;


import java.util.Objects;

public class Student
{
    private String name;
    private int age;

    public Student()
    {
    }

    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }


    public void Study()
    {
        System.out.println("Study");
    }

    public void HomeWork()
    {
        System.out.println("HomeWork");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public void setAge(int age)
    {
//        if (age<0||age>120)
//        {
//            System.out.println("输入有误");
//        }
//        else
//        {
        this.age = age;
//        }
    }

    public void Show()
    {
        System.out.println(name + "," + age);
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}
