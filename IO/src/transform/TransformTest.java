package transform;

import org.junit.Test;

import java.io.*;

/**
 * 转换流：
 * InputStreamReader:字符输入流。将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter:字符输出流。将一个字符的输出流转换为字节的输入流
 * 作用：
 * 提供字节流与字符流之间的转换
 * 解码：
 *
 * @author clown
 * @Date 2021/1/2 0002 21:51
 */
public class TransformTest {
    @Test
    public void test() throws IOException {
        File file = new File("demo.txt");
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
        char[] cBuf = new char[512];
        int len;
        while ((len = isr.read(cBuf)) != -1) {
            String s = new String(cBuf, 0, len);
            System.out.println(s);
        }
        isr.close();
    }

    @Test
    public void test1() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("demo.txt"),"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("clown.txt"), "GBK");
        char[] cBuf = new char[512];
        int len;
        while ((len = isr.read(cBuf))!=-1){
            osw.write(cBuf,0,len);
        }
        osw.close();
        isr.close();
    }
}


























