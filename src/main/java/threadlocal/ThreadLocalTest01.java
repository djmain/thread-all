package threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * created by Jay on 2019/6/20
 */
public class ThreadLocalTest01
{
    private static ThreadLocal<Long> threadLocal = new ThreadLocal();

    public static Long get()
    {
        if (null == value)
        {
            value = Thread.currentThread().getName();
            System.out.println("initialValue:" + value);
            threadLocal.set(value);
        }
        return value;
    }

    public static void set(String value)
    {
        threadLocal.set(value);
    }

    public static void remove()
    {
        threadLocal.remove();
    }

    public static void run()
    {
        try
        {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}


