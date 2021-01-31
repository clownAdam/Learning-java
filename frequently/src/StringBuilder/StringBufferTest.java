package StringBuilder;

import org.junit.Before;
import org.junit.Test;

/**
 * @author clown
 */
public class StringBufferTest {
    @Test
    public void test() {
        StringBuffer stringBuffer = new StringBuffer("abc");
        System.out.println(stringBuffer.length());
        stringBuffer.setCharAt(0, 'm');
        System.out.println(stringBuffer);
        stringBuffer.append("def");
        System.out.println(stringBuffer);
    }

    StringBuffer stringBuffer = new StringBuffer();

    @Before
    public void before() {
        stringBuffer.append("a");
        stringBuffer.append(1);
        stringBuffer.append("b");
    }

    /**
     * StringBuffer append():
     * 字符串拼接
     */
    @Test
    public void append() {
        stringBuffer.append(1);
        stringBuffer.append("1");
        System.out.println(stringBuffer);
    }

    /**
     * StringBuffer delete(int start,int end):
     * 删除指定位置的内容
     */
    @Test
    public void delete() {
        System.out.println(stringBuffer);
        stringBuffer.delete(0, 1);
        System.out.println(stringBuffer);
    }

    /**
     * StringBuffer replace(int start,int end String str):
     * 把[start,end)位置替换为str
     */
    @Test
    public void replace() {
        System.out.println(stringBuffer);
        stringBuffer.replace(0, 1, "hello");
        System.out.println(stringBuffer);
    }

    /**
     * StringBuffer insert(int offset,xxx):
     * 在指定位置插入
     */
    @Test
    public void insert() {
        System.out.println(stringBuffer);
        stringBuffer.insert(0, true);
        System.out.println(stringBuffer);

    }

    /**
     * StringBuffer reverse():
     * 把当前字符序列逆转
     */
    @Test
    public void reverse() {
        stringBuffer.reverse();
        System.out.println(stringBuffer);
        char c = stringBuffer.charAt(2);
        System.out.println(c);
        stringBuffer.setCharAt(2,'b');
        System.out.println(stringBuffer);
    }

}
