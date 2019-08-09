import org.junit.Test;
import com.jay.thread.Task;
import com.jay.thread.Task01;
import com.jay.thread.ThreadLocalTest01;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * created by Jay on 2019/6/20
 */
public class TestThread
{
    public static void main(String[] args)
    {
        new Thread(new Task()).start();
        new Thread(new Task()).start();
    }

    @Test
    public void testThreadLocal01()
    {
        new Thread(new Task01()).start();
        new Thread(new Task01()).start();
        try
        {
            System.in.read();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 利用threadLocal统计代码耗时 consume time
     */
    @Test
    public void testCostTime()
    {
        ThreadLocalTest01.begin();
        ThreadLocalTest01.run();
        ThreadLocalTest01.end();
    }

    /**
     * 线程消亡
     */
    @Test
    public void testThreadDead() throws InterruptedException
    {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread t = new Thread((() -> {
            System.out.println("aa");
            countDownLatch.countDown();
        }));
        Map<Thread, Object> map = new HashMap<>();
        map.put(t, "a");
        t.start();
        countDownLatch.await();
        System.out.println(map);
        System.out.println(Thread.State.TERMINATED.name());
    }
}
