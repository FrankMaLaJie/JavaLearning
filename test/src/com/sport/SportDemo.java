package com.sport;

public class SportDemo
{
    public static void main(String[] args)
    {
        //创建对象
        TableTennisPlayer ttp = new TableTennisPlayer();
        ttp.setName("张继科");
        ttp.setAge(30);
        ttp.show();
        ttp.eat();
        ttp.study();
        ttp.speakEnglish();

        System.out.println("-------------------");

        BasketballPlayer bp = new BasketballPlayer("姚明", 45);
        bp.show();
        bp.eat();
        bp.study();

    }
}
