package com.jay.thread.callable;

import java.util.concurrent.Callable;

/**
 * created by Jay on 2019/8/9
 */
public class MyCallable implements Callable<String>
{
    @Override
    public String call() throws Exception
    {
        System.out.println(Thread.currentThread().getName() + " is running.");
        return "over";
    }
}
