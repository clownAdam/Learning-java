import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar（日历类）
 *
 * @author clown
 * @since 1.8
 */
public class CalendarTest {
    @Test
    public void calendar(){
        Calendar calendar = Calendar.getInstance();
        //get
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        int year = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(year);
        //set
        calendar.set(Calendar.DAY_OF_MONTH,22);
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        //add
        calendar.add(Calendar.DAY_OF_MONTH,3);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        //getTime
        Date time = calendar.getTime();
        System.out.println(time);
        //setTime
        Date date = new Date();

        calendar.setTime(date);
    }
}
