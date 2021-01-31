/**
 * @author clown
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("hello,world");
        myThread.start();
        new MyThread().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(i);
            }
        }
    }
}