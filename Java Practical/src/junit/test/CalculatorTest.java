package junit.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest
{
    /*
    * 初始化方法：
    * 用于资源申请，所有测试方法在执行之前都会先执行该方法
    * */
    @Before
    public void init(){
        System.out.println("init");
    }

    /*
     * 释放资源方法：
     * 所有测试方法执行之后都会自动执行该方法
     * */
    @After
    public void close(){
        System.out.println("close");
    }



    /*
     * 测试add方法
     * */
    @Test
    public void testAdd(){
        System.out.println("执行");
    }
}



