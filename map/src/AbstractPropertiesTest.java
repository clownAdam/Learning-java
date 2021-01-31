import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author clown
 */
public abstract class AbstractPropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("jdbc.properties");
            properties.load(inputStream);
            String password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
