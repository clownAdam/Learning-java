import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作,使用iterator接口
 *
 * @author clown
 */
public class IteratorTest {
    @Test
    public void test3() {
        String[] strings = {"MM"};

    }

    @Test
    public void test2() {
        Collection list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new Person("jerry", 20));
        list.add(new String("Tom"));
        list.add(false);

        for (Object o : list) {
            System.out.println(o);
        }

    }

    @Test
    public void test() {
        Collection list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new Person("jerry", 20));
        list.add(new String("Tom"));
        list.add(false);

//        Iterator iterator = list.iterator();
//
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        Iterator iter = list.iterator();

        while (iter.hasNext()) {
            Object next = iter.next();
            if ("Tom".equals(next)) {
                iter.remove();
            }
        }
        Iterator iter1 = list.iterator();
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }

    }
}
