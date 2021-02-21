import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author clown
 * @Date 2021/2/19 0019 3:17
 */
public class InetAddressTest {
    @Test
    public void test() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost());
    }

}
