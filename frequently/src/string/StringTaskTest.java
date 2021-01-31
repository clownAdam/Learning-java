package string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author clown
 */
public class StringTaskTest {
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
     * 1.模拟一个trim方法,去除字符串两端的空格
     */
    @Test
    public void test1() {
        String string = "   he  llo -  ";
        int length = string.length();
        string.trim();
        int st = 0;
        char[] val = string.toCharArray();
        while ((st < length) && val[st] == ' ') {
            st++;
        }
        while ((st < length) && (val[length - 1] == ' ')) {
            length--;
        }
        String substring = string.substring(st, length);
        System.out.println(substring);
    }

    /**
     * 2.将一个字符串进行反转.将字符串中指定部分进行反转。
     */
    @Test
    public void test2() {
        String str = "clown";
        char[] chars = str.toCharArray();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        String res = new String(chars);
        System.out.println(res);
    }

    @Test
    public void test22() {
        String string = "clown";
        String reverse = reverse(string, 1, 3);
        String reverse1 = reverse1(string, 1, 3);
        String reverse2 = reverse2(string, 1, 3);
        System.out.println(reverse);
        System.out.println(reverse1);
        System.out.println(reverse2);
    }

    public String reverse2(String str, int startIndex, int endIndex) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        stringBuilder.append(str, 0, startIndex);
        for (int i = endIndex; i >= startIndex; i--) {
            stringBuilder.append(str.charAt(i));
        }
        stringBuilder.append(str.substring(endIndex + 1));
        return stringBuilder.toString();
    }

    public String reverse1(String str, int startIndex, int endIndex) {
        if (str != null) {
            String reverseStr = str.substring(0, startIndex);
            for (int i = endIndex; i >= startIndex; i--) {
                reverseStr += str.charAt(i);
            }
            reverseStr += str.substring(endIndex + 1);
            return reverseStr;
        }
        return null;
    }

    public String reverse(String str, int startIndex, int endIndex) {
        if (str == null) {
            return null;
        }
        if (startIndex < 0) {
            System.out.println("startIndex!<0");
            return "startIndex!<0";
        }
        if (endIndex >= str.length()) {
            System.out.println("endIndex!>str.length()");
            return "endIndex!>str.length()";
        }
        char[] array = str.toCharArray();
        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        String s = new String(array);
        return s;
    }

    /**
     * 3.获取一个字符串在另一个字符串中出现的次数
     */
    @Test
    public void test3() {
        String str = "abkkcabdkabkebfkabkskab";
        String subStr = "ab";
        //5
        int count = 0;
        int strLength = str.length();
        int subStrLength = subStr.length();
        int index = str.indexOf(subStr);
        while (index != -1) {
            ++count;
            index = str.indexOf(subStr, index + subStrLength);
        }
        System.out.println("count = " + count);
    }

    @Test
    public void test33() {
        String str = "aab";
        String subStr = "ab";
        int count = getCount(str, subStr);
        System.out.println("count = " + count);
    }

    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        if (mainLength >= subLength) {
            int index = mainStr.indexOf(subStr);
            while (index != -1) {
//                ++count;
                count++;
                index = mainStr.indexOf(subStr, index + subLength);
            }
            return count;
        } else {
            return 0;
        }
    }

    /**
     * 4.获取两个字符串中最大相同子串
     * str1="abcwerthelloyuiodef"
     * str2="cvhellobnm"
     */
    @Test
    public void test4() {

    }

    public String getMaxSameString(String str1, String str2) {
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        int length = minStr.length();
        for (int i = 0; i < length; i++) {
        }

        return null;
    }

    /**
     * 5.对字符串中字符进行自然顺序排序
     */
    @Test
    public void test5() {
        String str = "bajiege";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(new String(chars));
    }

    /**
     * 给定一个整数的数组，相邻的数不能同时选，求从该数组选取若干整数，使得他们的和最大，要求只能使用o(1)的空间复杂度。要求给出伪码。
     */
    public int getMax(int[] a, int len) {
        int[] ar = new int[]{};

        return ar.length;
    }
}
