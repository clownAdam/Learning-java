package runnable;

/**
 * @author clown
 */
public class RunnableDemo {
    public static void main(String[] args) {
        MeThread meThread = new MeThread();
        new Thread(meThread).start();
        new Thread(meThread).start();
    }
}

class MeThread implements Runnable {

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