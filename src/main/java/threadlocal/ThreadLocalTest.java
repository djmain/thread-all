package threadlocal;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * created by Jay on 2019/6/20
 */
public class ThreadLocalTest
{
    private static ThreadLocal<String> threadLocal = new ThreadLocal()
    {
        @Override
        protected String initialValue()
        {
            String initialValue = Thread.currentThread().getName();
            System.out.println("initialValue:" + initialValue);
            return initialValue;
        }
    };

    public static String get()
    {
        return threadLocal.get();
    }

    public static void set(String value)
    {
        threadLocal.set(value);
    }

    public static void remove()
    {
        threadLocal.remove();
    }

}


