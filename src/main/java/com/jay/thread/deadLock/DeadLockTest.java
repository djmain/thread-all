package com.jay.thread.deadLock;

/**
 * created by Jay on 2019/8/9
 */
public class DeadLockTest
{
    public static void main(String[] args)
    {
        new Thread(new DeadTask(true)).start();
        new Thread(new DeadTask(false)).start();
    }
}
