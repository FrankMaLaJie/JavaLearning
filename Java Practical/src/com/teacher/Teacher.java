package com.teacher;

public class Teacher extends Human
{
    public Teacher()
    {
    }

    public Teacher(String name, int age)
    {
        super(name, age);
    }

    public void teach(){
        System.out.println("用爱成就每一位学生");
    }
}
