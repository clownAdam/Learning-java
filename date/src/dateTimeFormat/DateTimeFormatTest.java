package dateTimeFormat;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author clown
 */
public class DateTimeFormatTest {
    @Test
    public void test(){
        DateTimeFormatter dateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        String format = dateTime.format(localDateTime);
        System.out.println(format);

        TemporalAccessor parse = dateTime.parse(format);
        System.out.println(parse);
    }
    @Test
    public void test2(){
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String format = formatter.format(LocalDateTime.now());
        System.out.println(format);

        System.out.println(formatter.parse(format));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String format1 = dateTimeFormatter.format(LocalDate.now());
        System.out.println(format1);

        System.out.println("****************");
        DateTimeFormatter timeFormatter = dateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(timeFormatter.format(LocalDate.now()));
        System.out.println(timeFormatter.format(LocalDateTime.now()));

        TemporalAccessor parse = timeFormatter.parse("2020-10-11");
        System.out.println(parse);

    }
}
