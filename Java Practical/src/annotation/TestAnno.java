package annotation;


@Pro(className = "annotation.Demo1", methodName = "show")
public class TestAnno
{
    public static void main(String[] args)
    {
        //解析注解
        //获取该类的字节码文件对象
        Class<TestAnno> cls = TestAnno.class;

        //获取注解对象
        //其实就是在内存中生成了一个该注解接口的子类实现对象
        /*public class ProImpl implements Pro
        {
            public String className()
            {
                return "annotation.Demo1";
            }

            public String methodName()
            {
                return "show";
            }
        }
        */
        Pro an = cls.getAnnotation(Pro.class);

        //调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();

        System.out.println(className);
        System.out.println(methodName);
    }

}
