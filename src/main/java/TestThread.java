import org.junit.Test;
import threadlocal.Task;
import threadlocal.Task01;

import java.io.IOException;

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
}
