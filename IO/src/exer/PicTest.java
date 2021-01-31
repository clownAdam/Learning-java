package exer;

import org.junit.Before;
import org.junit.Test;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author clown
 * @Date 2021/1/2 0002 21:01
 */
public class PicTest {
    File file = null;
    File file1 = null;

    @Before
    public void before() {
        file = new File("1.png");
        file1 = new File("1_sss.png");
    }

    @Test
    public void test1() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("1secret.png");
        FileOutputStream fileOutputStream = new FileOutputStream("11111.png");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
            //对图片进行加密
            for (int i = 0; i < len; i++) {
                bytes[i] = (byte) (bytes[i] ^ 5);
            }
            fileOutputStream.write(bytes, 0, len);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }

    @Test
    public void test2() throws Exception {
        FileImageInputStream fileImageInputStream = new FileImageInputStream(file);
        FileImageOutputStream fileImageOutputStream = new FileImageOutputStream(file1);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileImageInputStream.read(bytes)) != -1) {
            fileImageOutputStream.write(bytes, 0, len);
        }
        fileImageInputStream.close();
        fileImageOutputStream.close();
    }
}
