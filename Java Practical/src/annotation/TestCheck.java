package annotation;

/*
 * 简单的测试框架
 *
 * 当主方法执行后，会自动执行被检测的所有方法（加了Check注解的方法）
 * 判断方法是否有异常，记录到文件中
 * */

import junit.junit.Calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck
{
    public static void main(String[] args) throws IOException
    {
        //创建计算器对象
        Calculator c = new Calculator();

        //获取字节码文件对象
        Class cls = c.getClass();

        //获取所有的方法
        Method[] methods = cls.getMethods();

        int num = 0;//出现异常的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method m : methods)
        {
            //判断方法上是否有check注解
            if (m.isAnnotationPresent(Check.class))
            {
                //有执行
                try
                {
                    m.invoke(c);
                } catch (Exception e)
                {
                    //捕获异常，记录到文件中
                    num++;

                    bw.write(m.getName() + "方法出异常了");
                    bw.newLine();
                    bw.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("--------------");
                    bw.newLine();
                }

            }
        }
        bw.write("本次测试一共出现" + num + "次异常");
        bw.flush();
        bw.close();
    }
}
