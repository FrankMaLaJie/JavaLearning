package com.sport;

public class BasketballPlayer extends Player
{
    public BasketballPlayer()
    {
    }

    public BasketballPlayer(String name, int age)
    {
        super(name, age);
    }

    @Override
    public void eat()
    {
        System.out.println("篮球运动员，吃牛肉，喝牛奶");
    }

    @Override
    public void study()
    {
        System.out.println("篮球运动员，学习投篮和运球");
    }
}
