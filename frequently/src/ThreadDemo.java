/**
 * @author clown
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        /*myThread1.setPriority(8);*/
        myThread1.start();
        MyThread1 myThread2 = new MyThread1();
        myThread2.start();
        MyThread1 myThread3 = new MyThread1();
        myThread3.start();
       /* MyThread1 myThread11 = new MyThread1();
       *//* myThread11.setPriority(1);*//*
        myThread11.start();

        new MyThread1().start();*/
//        new ThreadDemo().run();
//        new ThreadDemo().run();
//        new ThreadDemo().run();

//        MyThread2 myThread2 = new MyThread2();
//        new Thread(myThread2).start();
//        new Thread(myThread2).start();
//        new Thread(myThread2).start();
    }

    public void run() {
        for (int j = 0; j < 10; j++) {
            show();
        }
    }
    int i = 0;
    public void show() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        System.out.println(i);
    }
}

class MyThread1 extends Thread {

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            show();
        }
    }




    public void show() {
        int i = 0;
//        if (i == 0) {
        i++;
        System.out.println(i);
//        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        int i = 0;
        if (i == 0) {
            i++;
            System.out.println(i);
        }
    }
}
