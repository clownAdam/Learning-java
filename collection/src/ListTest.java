import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author clown
 */
public class ListTest {
    /**
     * ArrayList
     * LinkedList
     * Vector
     * 同:都实现了List接口,存储数据的特点相同(有序,可重复的数据)
     *    ArrayList和Vector底层使用Object[] elementData存储
     * 不同:
     * >>ArrayList作为List接口的主要实现类,执行效率高,线程不安全。
     * >>Vector:作为List接口的古老实现类,线程安全,效率低.
     * >>LinkedList:底层使用的是双向链表存储,对于频繁的插入和删除操作使用.
     */
    @Test
    public void arrayListTest() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);
        list.add(null);
        System.out.println(list);
        list.add(0,"BB");
        System.out.println(list);

        List<Integer> integers = Arrays.asList(1, 2, 3);
        list.addAll(integers);

        System.out.println(list.size());

        System.out.println(list.get(1));

        int i = list.indexOf("BB");
        System.out.println(i);


    }

    @Test
    public void linkedListTest() {

    }

    @Test
    public void vectorTest() {

    }
}
