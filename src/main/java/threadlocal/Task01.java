package threadlocal;

/**
 * created by Jay on 2019/6/20
 */
public class Task01 implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println(Thread.currentThread().getName() + " get value:" + ThreadLocalTest01.get());
            ThreadLocalTest01.set(ThreadLocalTest01.get() + String.valueOf(i));
        }
        ThreadLocalTest01.remove();
    }
}
