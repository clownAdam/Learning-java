package single;

/**
 * 使用同步机制将单列设计模式中的懒汉式改写为线程安全的
 *
 * @author clown
 */
public class BankTest {
    public static void main(String[] args) {

    }
}

class Bank {
    private Bank() {}

    private static Bank instance = null;

    public static synchronized Bank getInstance() {
        /*synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
            return instance;
        }*/
        if(instance == null){
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}