import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * String,重写compareTo()方法以后的包装类，默认进行了从小到大的排列。
 * 重写compareTo(obj)的规则：
 * 如果当前对象this大于形参对象obj,则返回正整数;
 * 如果当前对象this小于形参对象obj,则返回负整数;
 * 如果当前对象this等于形参对象obj,则返回零.
 *
 * @author clown
 */
public class CompareTest {
    @Test
    public void comparable() {
        String[] strings = {"b", "d", "b", "f", "c", "a", "e", "A"};
        System.out.println(Arrays.toString(strings));
        //排序
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }

    /**
     * Comparable:自然排序
     */
    @Test
    public void comparableGoods() {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("lenovoMouse", 34);
        goods[1] = new Goods("dellMouse", 43);
        goods[2] = new Goods("xiaomiMouse", 43);
        goods[3] = new Goods("huaweiMouse", 65);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    /**
     * Comparator:定制排序。
     * 重写compare(T o1, T o2)方法:比较o1和o2的大小
     * 如果方法返回正整数,则表示o1大于o2
     * 如果返回0,表示相等
     * 如果返回负整数,表示o1小于o2
     */
    @Test
    public void comparatorGoods() {
        String[] strings = {"b", "d", "b", "f", "c", "a", "e", "A"};
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("lenovoMouse", 34);
        goods[1] = new Goods("dellMouse", 43);
        goods[2] = new Goods("dellMouse", 444);
        goods[3] = new Goods("huaweiMouse", 65);
        Arrays.sort(strings, (Comparator<String>) (o1, o2) -> {
            if (o1 != null && o2 != null) {
                String s1 = (String) o1;
                String s2 = (String) o2;
                return -s1.compareTo(s2);
            }
            throw new RuntimeException("impute");
        });
        Arrays.sort(goods, (Comparator<Goods>) (o1, o2) -> {
            if (o1 != null && o2 != null) {
                Goods goods1 = (Goods) o1;
                Goods goods2 = (Goods) o2;
                if (goods1.getName().equals(goods2.getName())) {
                    return -Double.compare(goods1.getPrice(), goods2.getPrice());
                } else {
                    return goods1.getName().compareTo(goods2.getName());
                }

            }
            return 0;
        });
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(goods));
    }
}
