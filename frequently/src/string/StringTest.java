package string;

import org.junit.Test;

/**
 * @author clown
 */
public class StringTest {
    String str = "good";
    char[] ch = new char[]{'t','e','s','t'};
    public void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
    }
    /**
     * String
     * Serializable, Comparable<String>, CharSequence
     * 字符串支持序列化
     * 字符串可以比较大小
     * 内部定义了final char[] 用于存储字符串数据
     * String代表一个不可变的字符序列
     */
    @Test
    public void test(){
        String s1 = "abc";
        String s2 = "abc";
        s1 = "hello";
        System.out.println(s1);
        System.out.println(s2);
    }
    @Test
    public void test2(){
        //string的实例化
        //字面量+new
        String s1 = "abc";
        String s2 = new String("abc");

    }

    @Test
    public void test3(){
        String s1 = "javaee";
        String s2 = "hadoop";
        String s3 = "javaeehadoop";
        String s4 = "javaee"+"hadoop";
        String s5 = s1 +"hadoop";
    }
}
