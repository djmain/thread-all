package threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * created by Jay on 2019/6/20
 */
public class ThreadLocalTest01
{
    private static ThreadLocal<Long> threadLocal = new ThreadLocal()
    {

        @Override
        protected Object initialValue()
        {
            return System.currentTimeMillis();
        }
    };

    public static Long get()
    {
        return threadLocal.get();
    }

    public static void set(Long value)
    {
        threadLocal.set(value);
    }

    public static void remove()
    {
        threadLocal.remove();
    }

    public static void begin()
    {
        threadLocal.get();
    }

    public static void end()
    {
        Long begin = threadLocal.get();
        System.out.println("cost:" + (System.currentTimeMillis() - begin));
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


