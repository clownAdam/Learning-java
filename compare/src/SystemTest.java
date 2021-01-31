import org.junit.Test;

/**
 * @author clown
 */
public class SystemTest {
    @Test
    public void testSystem() {
        String key = "user.dir";
        String property = System.getProperty(key);
        System.out.println(property);
    }
}
