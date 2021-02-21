import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author clown
 * @Date 2021/2/18 0018 21:56
 */
public class RandomAccessFileTest {
    @Test
    public void test() {
        try (RandomAccessFile r = new RandomAccessFile("test.txt", "r");
             RandomAccessFile w = new RandomAccessFile("test1.txt", "rw");) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = r.read(buffer)) != -1) {
                w.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile rw = new RandomAccessFile("test1.txt", "rw");
        rw.write("xyz".getBytes());
        rw.close();
    }

    @Test
    public void test3() throws IOException {
        File file = new File("test1.txt");
        RandomAccessFile rw = new RandomAccessFile(file, "rw");
        int index = 3;
        rw.seek(index);
        StringBuilder sb = new StringBuilder((int) file.length());

        byte[] buffer = new byte[1024];
        int len;
        while ((len = rw.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, len));
        }
        rw.seek(3);
        rw.write(",abc".getBytes());
        rw.write(sb.toString().getBytes());
        rw.close();
    }

}
