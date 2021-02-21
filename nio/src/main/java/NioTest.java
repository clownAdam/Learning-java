import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author clown
 * @Date 2021/2/18 0018 23:24
 */
public class NioTest {
    @Test
    public void test() {
        Path path = Paths.get("");
    }

    @Test
    public void testMain() throws IOException {
        FileUtils.copyFile(new File("d://countq.log"), new File("count.log"));

    }
}
