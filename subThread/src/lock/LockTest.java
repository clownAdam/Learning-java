package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全的问题:
 * synchronized--:同步代码块和同步方法
 * lock
 *
 * @author clown
 */
public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {
    private int ticket = 100;
    /**
     * 实例化reentrantLock
     */
    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            reentrantLock.lock();
            try {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":售票,票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }
} 