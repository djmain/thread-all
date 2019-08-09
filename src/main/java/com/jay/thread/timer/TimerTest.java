package com.jay.thread.timer;

import com.jay.tool.time.TimeTool;

import java.util.Timer;
import java.util.TimerTask;

/**
 * created by Jay on 2019/8/9
 */
public class TimerTest
{
    public static void main(String[] args)
    {
        System.out.println(TimeTool.now() + " begin");
        new Timer().scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                System.out.println(TimeTool.now() + " Hello");
            }
        }, 5000, 1000);
        Thread t= null;
    }
}
