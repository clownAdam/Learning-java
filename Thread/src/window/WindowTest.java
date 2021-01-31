package window;

/**
 * @author clown
 */
public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");

        window1.start();
        window2.start();
        window3.start();
    }
}
class Window extends Thread{
    private static int tricket = 100;

    @Override
    public void run() {
        while (true){
            if(tricket>0){
                System.out.println(getName()+":卖票,票号为："+tricket);
                tricket--;
            }else {
                break;
            }
        }
    }
}