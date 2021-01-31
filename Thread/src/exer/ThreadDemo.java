package exer;

/**
 * @author clown
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();

        new Thread(() -> {
            System.out.println("hello");
        }).start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        int count = 100;
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        int count = 100;
        for (int i = 0; i < count; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
