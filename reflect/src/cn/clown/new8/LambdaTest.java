package cn.clown.new8;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用
 *
 * @author clown
 */
public class LambdaTest {
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("i love beijing tianAnMen");
            }
        };

        runnable.run();

        System.out.println("******************************************************");
        //TODO:lambda表达式
        Runnable runnable1 = () -> System.out.println("i love beijing tianAnMen");
        runnable1.run();

    }

    @Test
    public void test2(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare = comparator.compare(21, 21);
        System.out.println(compare);
        System.out.println("*******************************");
        Comparator<Integer> comparator1 = (a,b)->Integer.compare(a,b);

        int compare1 = comparator1.compare(12, 12);
        System.out.println(compare);

        System.out.println("*********************************");

        Comparator<Integer> comparator3 = Integer::compare;
        System.out.println(comparator3.compare(1, 1));

    }
}

