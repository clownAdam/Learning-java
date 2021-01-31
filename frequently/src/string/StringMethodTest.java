package string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author clown
 */
public class StringMethodTest {
    String s1 = "helloWorld";

    @Test
    public void length() {
        //string字符串的长度
        System.out.println(s1.length());
    }

    /**
     * char charAt(int index)
     * 返回某索引处的字符 return value[index]
     */
    @Test
    public void charAt() {
        System.out.println(s1.charAt(9));
    }

    /**
     * boolean isEmpty() 判断是否为空字符串
     */
    @Test
    public void isEmpty() {
        s1 = "";
        System.out.println(s1.isEmpty());
    }

    /**
     * toLowerCase():将String中的所有字符转换为小写
     */
    @Test
    public void toLowerCase() {
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
    }

    /**
     * trim:返回字符串的副本,忽略前导空白和尾部空白
     */
    @Test
    public void trim() {
        System.out.println(s1.trim());
    }

    @Test
    public void equals() {
        String s2 = "HELLOWORLD";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
    }

    /**
     * String concat(String str):
     * 将制定的字符串连接到此字符串的结尾.等价于"+"
     */
    @Test
    public void concat() {
        System.out.println(s1.concat("-你好，中国"));
    }

    /**
     * int compareTo(String anotherString)
     * 比较两个字符串的大小
     */
    @Test
    public void compareTo() {
        System.out.println(s1.compareTo("abc"));
    }

    /**
     * sub
     */
    @Test
    public void subString() {
        System.out.println(s1.substring(1, 2));
        System.out.println(new String("abc".toCharArray(), 1, 2));
    }

    /**
     * boolean endsWith(String suffix):
     * 测试此字符串是否以指定的后缀结束
     */
    @Test
    public void endsWith() {
        System.out.println(s1);
        System.out.println(s1.endsWith("World"));
    }

    @Test
    public void startsWith() {
        System.out.println(s1);
        System.out.println(s1.startsWith("e", 1));
    }

    /**
     * boolean contains(CharSequence s):
     * 当且仅当此字符串包含指定的char值序列时,返回true
     */
    @Test
    public void contains() {
        System.out.println(s1.contains("Wor"));
    }

    /**
     * int indexOf(String str)
     * 返回指定子字符串在此字符串中第一次出现的索引
     */
    @Test
    public void indexOf() {
        String s1 = "helloWorld";
        System.out.println(s1.indexOf("o", 5));
        System.out.println(s1.indexOf("o"));
    }

    /**
     * 计算子字符出现的次数
     */
    @Test
    public void testCount() {
        String str = "ccc";
        String subStr = "cc";
        int strLength = str.length();
        int subStrLength = subStr.length();
        int count = 0;
        int index = str.indexOf(subStr);
        while (index != -1) {
            count++;
            index = str.indexOf(subStr, index + subStrLength);
        }
        System.out.println(count);
    }

    /**
     * lastIndexOf(String str):
     * 返回指定子字符串在此字符串中最右边出现处的索引(从后往前数)
     */
    @Test
    public void lastIndexOf() {
        String str = "abca";
        System.out.println(str.lastIndexOf("a"));
        System.out.println(str.indexOf("a"));
    }

    /**
     * String replace(char oldChar,char newChar):
     * 返回一个新的字符串,它是通过newChar替换此字符串中出现的所有oldChar得到的
     */
    @Test
    public void replace() {
        String str = "clownAdam";
        Integer.parseInt("111");
        System.out.println(str.replace('c', 'a'));
        String.valueOf(1);
        String s = String.valueOf(new char[]{'a'});
        System.out.println(s);
    }

    @Test
    public void reverse() {
        String str = "abc1234";
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int x = 0, y = length - 1; x < y; x++, y--) {
            char temp = chars[x];
            chars[x] = chars[y];
            chars[y] = temp;
        }
        System.out.println(String.valueOf(chars));
    }
    @Test
    public void stringToByte() throws UnsupportedEncodingException {
        String str = "abc12中国";
        byte[] bytes = str.getBytes("gbk");
        System.out.println(bytes);
        System.out.println(Arrays.toString(bytes));
        String s = Arrays.toString(bytes);
    }
}
