package Stream;

import org.junit.Test;

import java.io.*;

/**
 * @author clown
 * @Date 2020/12/27 0027 18:26
 */
public class StreamTest {
    @Test
    public void test() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("demo.txt")));
             BufferedWriter writer = new BufferedWriter(new FileWriter(new File("demo3.txt")));) {
            String buffer = null;
            while ((buffer = reader.readLine()) != null) {
//                writer.write(buffer+"\n");
                writer.write(buffer);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
