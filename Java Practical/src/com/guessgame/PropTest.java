package com.guessgame;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropTest
{
    public static void main(String[] args) throws IOException
    {
        //从文件中读取数据到Properties集合，用`load()`方法实现
        Properties prop = new Properties();

        FileReader fr = new FileReader
                ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\guessgame\\game.txt");
        prop.load(fr);

        fr.close();

        //通过Properties集合获取到玩游戏的次数
        int count = Integer.parseInt(prop.getProperty("count"));

        //判断次数是否到了3次
        if (count >= 3){
            //给出提示
            System.out.println("游戏试玩结束，想继续请充值(www.malajie.com)");
        }
        else {
            //玩游戏
            GuessNumber.start();

            //次数+1，重新写回文件，用Properties的`store()`方法实现
            count++;
            prop.setProperty("count", String.valueOf(count));

            FileWriter fw = new FileWriter
                    ("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\guessgame\\game.txt");
            prop.store(fw,null);
            fw.close();
        }
    }
}
