import org.junit.Test;

import java.util.Date;

/**
 * @author clown
 * @since jdk1.8
 */
public class DateTest {
    /**
     * System类提供的
     *  public static long currentTimeMillis()
     */
    @Test
    public void date(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void demo(){
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());
        Date date1 = new Date(1602311985337L);
        System.out.println(date1.toString());
        java.sql.Date date2 = new java.sql.Date(1602311985337L);
        System.out.println(date2);

    }

}
