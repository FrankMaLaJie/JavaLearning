package com.stream;

public class Actor
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Actor(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Actor{" +
                "name='" + name + '\'' +
                '}';
    }
}
