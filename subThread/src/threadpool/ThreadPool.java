package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式：使用线程池
 *
 * @author clown
 */
public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        executorService.setCorePoolSize(15);
//        executorService.execute(new NumberThread());
//        executorService.execute(new NumberThread1());
        executorService.shutdown();
    }
}

class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}