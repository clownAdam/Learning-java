package endor;

import org.junit.Test;

import java.io.*;

/**
 * InputStream
 * OutputStream
 * Reader
 * Writer
 *
 * @author clown
 * @Date 2020/12/10 0010 22:21
 */
public class FileReaderWriterTest {
    @Test
    public void test() {
        File file = new File("hello.txt");
        try (FileReader fileReader = new FileReader(file)) {
            int read = fileReader.read();
            while (read != -1) {
                System.out.print((char) read);
                read = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test1() throws IOException {
        File file = new File("hello.txt");
        FileReader fileReader = new FileReader(file);
        char[] charsBuf = new char[5];
        int len;
        while ((len = fileReader.read(charsBuf)) != -1) {
            String s = new String(charsBuf, 0, len);
            System.out.println(s);
        }
        fileReader.close();
    }

    @Test
    public void testWriter() throws IOException {
        File file = new File("hello1.txt");
        FileWriter fileWriter = new FileWriter(file, true);

        fileWriter.write("hello world clown dream\n");
        fileWriter.write("clcown");
        if (fileWriter != null) {
            fileWriter.close();
        }
    }

    @Test
    public void testDemo() {
        File readFile = new File("hello.txt");
        File writeFile = new File("demo.txt");

        try (FileReader fileReader = new FileReader(readFile);
             FileWriter fileWriter = new FileWriter(writeFile)) {

            char[] chars = new char[10];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, len);
//                fileWriter.write(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test33() {
//        CopyFile();
        final long startTime = System.currentTimeMillis();
        copyFile("demo.txt", "2.avi.txt");
        final long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    @Test
    public void testBufferStream() throws IOException {
        File readFile = new File("1.png");
        File writeFile = new File("3.png");

        BufferedInputStream readBis = new BufferedInputStream(new FileInputStream(readFile));
        final BufferedOutputStream writeBos = new BufferedOutputStream(new FileOutputStream(writeFile));
        final byte[] buffer = new byte[256];
        int len;
        while ((len = readBis.read(buffer)) != -1) {
            writeBos.write(buffer, 0, len);
        }
        writeBos.close();
        readBis.close();
    }

    /**
     * 缓冲流:效率高。提高流的读取、写入的速率
     */
    private void copyBufferFile() {

    }

    private void CopyFile() {
        File readFile = new File("1.png");
        File writeFile = new File("3.png");

        try (
                FileInputStream fileInputStream = new FileInputStream(readFile);
                FileOutputStream fileOutputStream = new FileOutputStream(writeFile);
        ) {
            byte[] bytes = new byte[4];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                System.out.println(s);
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 指定路径下文件的复制
     */
    public void copyFile(String srcPath, String destPath) {
        File readFile = new File(srcPath);
        File writeFile = new File(destPath);

        try (
                FileInputStream fileInputStream = new FileInputStream(readFile);
                FileOutputStream fileOutputStream = new FileOutputStream(writeFile);
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
