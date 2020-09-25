package com.sport;

import org.junit.Test;

public class BasketballCoach extends Coach
{
    public BasketballCoach()
    {
    }

    public BasketballCoach(String name, int age)
    {
        super(name, age);
    }

    @Override
    public void eat()
    {
        System.out.println("篮球教练，吃羊肉，喝羊奶");
    }

    @Override
    public void teach()
    {
        System.out.println("篮球教练，教投篮和运球");
    }

}
