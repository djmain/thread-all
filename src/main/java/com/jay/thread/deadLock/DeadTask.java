package com.jay.thread.deadLock;

import java.util.concurrent.TimeUnit;

import static com.jay.thread.deadLock.Lock.lockA;
import static com.jay.thread.deadLock.Lock.lockB;

/**
 * created by Jay on 2019/8/9
 */


public class DeadTask implements Runnable
{
    private boolean flag;

    public DeadTask(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public void run()
    {
        if (flag)
        {
            synchronized (lockA)
            {
                sleep();
                System.out.println(Thread.currentThread().getName() + " acquired lockA, try to qcquire lockB.");
                synchronized (lockB)
                {
                    System.out.println("acquired lockB");
                }
            }
        }
        else
        {
            synchronized (lockB)
            {
                sleep();
                System.out.println(Thread.currentThread().getName() + " acquired lockB, try to qcquire lockA.");
                synchronized (lockA)
                {
                    System.out.println("acquired lockA");
                }
            }
        }
    }

    private void sleep()
    {
        try
        {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


}


class Lock
{
    public static final Object lockA = new Object();
    public static final Object lockB = new Object();
}