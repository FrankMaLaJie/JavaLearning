package junit.junit;

import annotation.Check;

/**
 * 计算器类
 */

public class Calculator
{
    /**
     * 加法
     *
     * @return
     */
    @Check
    public int add()
    {
        return 1 + 0;
    }

    /**
     * 减法
     *
     * @return
     */
    @Check
    public int sub()
    {
        return 1 - 0;
    }

    /**
     * 乘法
     *
     * @return
     */
    @Check
    public int mul()
    {
        return 1 * 0;
    }

    /**
     * 除法
     *
     * @return
     */
    @Check
    public int div()
    {
        return 1 / 0;
    }
}
