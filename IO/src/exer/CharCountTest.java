package exer;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author clown
 * @Date 2021/1/2 0002 21:19
 */
public class CharCountTest {
    File file;

    @Before
    public void before() {
        file = new File("demo.txt");
    }

    @Test
    public void test() throws IOException {
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter("demo-char.txt");
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = new char[1024];
        int len;
        while ((len = fileReader.read(chars)) != -1) {
            for (int i = 0; i < len; i++) {
                if (map.containsKey(chars[i])) {
                    map.put(chars[i], map.get(chars[i]) + 1);
                } else {
                    map.put(chars[i], 1);
                }
            }
        }
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            if (key == '\n') {
                Integer value = next.getValue();
                fileWriter.write("换行" + "--" + value+"\n");
                continue;
            }
            if (key == ' ') {
                Integer value = next.getValue();
                fileWriter.write("空格" + "--" + value+"\n");
                continue;
            }
            if (key == '\r') {
                Integer value = next.getValue();
                fileWriter.write("回车" + "--" + value+"\n");
                continue;
            }
            if (key == '\t') {
                Integer value = next.getValue();
                fileWriter.write("tab键" + "--" + value+"\n");
                continue;
            }
            Integer value = next.getValue();
            fileWriter.write(key + "--" + value+"\n");
        }
        if (fileWriter != null) {
            fileWriter.close();
        }
        if (fileReader != null) {
            fileReader.close();
        }
    }
}
