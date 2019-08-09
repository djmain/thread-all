package com.jay.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * created by Jay on 2019/8/9
 */
public class CallableTest
{
    public static void main(String[] args) throws Exception
    {
        ExecutorService service = null;
        try
        {
            service = Executors.newFixedThreadPool(1);
            Future<String> future = service.submit(new MyCallable());
            System.out.println(future.get());
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (service != null)
            {
                service.shutdown();
            }
        }
    }
}
