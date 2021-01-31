import org.junit.Test;

import java.util.Scanner;

/**
 * @author clown
 */
public class TaskTest {
    /**
     * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。
     * 度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
     * ------
     * 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
     */
    @Test
    public void task() {
        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        System.out.println(i1);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        System.out.println(i1);
    }
}
