package cn.clown.new8;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * Lambda表达式的本质:作为函数式接口的实例
 * 函数式接口:
 *      如果一个借口中,只声明了一个抽象方法,则此接口就成为函数式接口.
 *
 *
 *
 * @author clown
 */
public class Lambda1Test {
    @Test
    public void test1() {
        //TODO:1,无参,无返回值
        Runnable runnable = () -> System.out.println("this is no constructor");
        runnable.run();
    }

    @Test
    public void test2() {
        //TODO:2,一个参数,无返回值
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(string);
            }
        };
        consumer.accept("hello,world!");

        Consumer<String> consumer1 = (s) -> System.out.println(s);
        consumer1.accept("hi!");
    }
    @Test
    public void test3(){
        //TODO:3,类型推断
        Consumer<String> consumer =(s) -> System.out.println(s);
        consumer.accept("hello,world!");

    }
}
