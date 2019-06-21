package threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * created by Jay on 2019/6/20
 */
public class Task implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println(Thread.currentThread().getName() + " get value:" + ThreadLocalTest.get());
            ThreadLocalTest.set(ThreadLocalTest.get() + String.valueOf(i));
        }
        ThreadLocalTest.remove();
    }
}
