package exer;

/**
 * Thread中方法的测试
 * yield():释放当前CPU的执行权,有可能在下一刻又得到CPU的执行权.
 * join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态,直到线程b完全执行完以后,线程a才结束阻塞状态.
 * stop():当执行此方法时,强制结束当前线程。
 * sleep(long millTime):让当前线程睡眠指定的millTime毫秒。在指定的milltime毫秒时间内
 * 当前线程是阻塞状态
 * isAlive():判断当前线程是否存活
 * @author clown
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        helloThread.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if(i ==20){
                try {
                    helloThread.join();
                    helloThread.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(helloThread.isAlive());
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}