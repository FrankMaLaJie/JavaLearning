package com.sport;

public class TableTennisCoach extends Coach implements SpeakEnglish
{
    public TableTennisCoach()
    {
    }

    public TableTennisCoach(String name, int age)
    {
        super(name, age);
    }

    @Override
    public void eat()
    {
        System.out.println("吃小白菜，喝大米粥");
    }

    @Override
    public void teach()
    {
        System.out.println("教如何发球和接球");
    }

    @Override
    public void speakEnglish()
    {
        System.out.println("乒乓球教练说英语");
    }
}
