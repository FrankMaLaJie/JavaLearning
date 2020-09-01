package com.sport;

public class TableTennisPlayer extends Player implements SpeakEnglish
{
    public TableTennisPlayer()
    {
    }

    public TableTennisPlayer(String name, int age)
    {
        super(name, age);
    }

    @Override
    public void eat()
    {
        System.out.println("乒乓球运动员，吃大白菜，喝小米粥");
    }

    @Override
    public void study()
    {
        System.out.println("乒乓球运动员，学习发球和接球");
    }

    @Override
    public void speakEnglish()
    {
        System.out.println("乒乓球运动员说英语");
    }
}
