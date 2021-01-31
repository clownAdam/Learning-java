package communication;

/**
 * 线程通信的案例:使用两个线程打印1-100.线程1,线程2,交替打印
 *
 * 线程通信的三个方法：
 *  wait():一旦执行此方法,当前线程就进入阻塞状态,并释放同步监视器
 *  notify():一旦执行此方法,就会唤醒被wait的一个线程,如果多个线程被wait,就唤醒优先级高的那个
 *  notifyAll():一旦执行此方法,就会唤醒所有被wait的线程
 *
 *  说明:
 *      上述三个方法的使用前提:必须使用在同步代码块或者同步方法中
 *      这三个方法的调用者必须是同步方法或同步代码块中的同步监视器
 *      否则会出现
 * @author clown
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable {
    private int number = 1;
    private Object object = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                object.notify();
                if (number <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number ++;
                    try {
                        //使得调用wait()方法的线程进入阻塞状态.
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
