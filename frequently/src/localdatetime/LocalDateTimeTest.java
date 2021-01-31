package localdatetime;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * LocalDate,LocalTime,LocalDateTime的使用
 *
 * @author clown
 */
public class LocalDateTimeTest {
    @Test
    public void localDateTime() {
        /*
         * now():获取当前的日期,时间,日期+时间
         */
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        /*
         * of()
         */
        LocalDate of = LocalDate.of(2020, 10, 10);
        LocalDateTime ofDateTime = LocalDateTime.of(2020, 3, 3, 3, 3, 3);
        System.out.println(ofDateTime);
        System.out.println(of);
        /*
         * getXxx()
         */
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getDayOfWeek().getValue());


    }

}
