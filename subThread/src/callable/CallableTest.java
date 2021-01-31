package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：
 * 实现callable接口.
 *
 * @author clown
 */
public class CallableTest {
    public static void main(String[] args) throws Exception {
        NumThread numThread = new NumThread();

        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();
        Object sum = futureTask.get();
        System.out.println("总和为："+sum);
    }
}

class NumThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}