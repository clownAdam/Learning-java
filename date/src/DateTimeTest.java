import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat：你和杨升是什么关系啊？
 * 1.格式化：日期-->指定格式的字符串
 * 2.解析：格式化的逆过程,字符串-->日期
 * 3.SimpleDateFormat的实例化
 * Calendar
 *
 * @author clown
 */
public class DateTimeTest {
    @Test
    public void test() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        //格式化
        Date date = new Date();
        System.out.println(date);
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        //解析
        Date parse = simpleDateFormat.parse(format);
        System.out.println(parse);

        Date parse1 = simpleDateFormat.parse("19-08-09 下午7:47");
        System.out.println(parse1);

        System.out.println("**********************************************");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
        Date date1 = new Date();
        String format1 = sdf.format(date1);
        System.out.println(format1);

    }

    /**
     * 1."2020-09-08" -->java.sql.Date
     */
    @Test
    public void task() throws ParseException {
        String str = "2020-09-08";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = dateFormat.parse(str);
        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date);
    }

    @Test
    public void job() {

    }
}
