package com.myInterface;

public class Demo
{
    public static void main(String[] args)
    {
        Jumping j = new Cat();
        j.jump();
        System.out.println("-----------------------");

        Animal a = new Cat();
        a.setName("布丁");
        a.setAge(5);
        a.show();
        a.eat();
        ((Cat) a).jump();
    }

}
