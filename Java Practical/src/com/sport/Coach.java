package com.sport;

public abstract class Coach extends Human
{
    public Coach()
    {
    }

    public Coach(String name, int age)
    {
        super(name, age);
    }

    public abstract void teach();
}
