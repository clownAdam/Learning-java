import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author clown
 */
public class InstantTest {
    @Test
    public void test(){
        Instant now = Instant.now();
        System.out.println(now);

        OffsetDateTime time = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(time);

        long milli = now.toEpochMilli();
        System.out.println(milli);

        Instant instant = Instant.ofEpochMilli(milli);
        System.out.println(instant);
    }
}
