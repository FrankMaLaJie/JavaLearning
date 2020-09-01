package com.collection;

import java.util.Objects;

public class Student
{
    private String name;
    private int age;
    private int chinese;
    private int math;

    public Student()
    {
    }

    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, int chinese, int math)
    {
        this.name = name;
        this.age = age;
        this.chinese = chinese;
        this.math = math;
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

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getChinese()
    {
        return chinese;
    }

    public void setChinese(int chinese)
    {
        this.chinese = chinese;
    }

    public int getMath()
    {
        return math;
    }

    public void setMath(int math)
    {
        this.math = math;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (chinese != student.chinese) return false;
        if (math != student.math) return false;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + chinese;
        result = 31 * result + math;
        return result;
    }

    public int getSum()
    {
        return this.getChinese() + this.getMath();
    }

    public void show()
    {
        System.out.println
                (name + ", " + age + "岁" +
                        ", 语文 " + chinese + "分" +
                        ", 数学 " + math + "分" +
                        ", 总分 " + this.getSum() + "分");
    }
}
