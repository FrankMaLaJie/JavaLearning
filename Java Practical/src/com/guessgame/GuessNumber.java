package com.guessgame;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber
{
    private GuessNumber()
    {
    }

    public static void start()
    {
        //要玩猜字游戏，首先要有一个被猜的数字，使用随机生成，范围是1-100
        Random random = new Random();
        int num = random.nextInt(100) + 1;

        while (true){
            //键盘录入每次猜的值
            Scanner sc = new Scanner(System.in);

            System.out.println("请输入你要猜的数字：");
            int guessNum = sc.nextInt();

            //比较输入的数字和产生的数字的大小
            if (guessNum > num){
                System.out.println("你猜的数字 " + guessNum + " 太大了");
            }
            else if(guessNum < num)
            {
                System.out.println("你猜的数字 " + guessNum + " 太小了");
            }
            else
            {
                System.out.println("恭喜你猜对了");
                break;
            }

        }
    }
}
