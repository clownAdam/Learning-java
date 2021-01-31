import org.junit.Test;

import java.util.*;

/**
 * Collection Collections
 * Collection:
 * Collections:
 * @author clown
 */
public class CollectionsTest {
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(45);
        list.add(56);
//        System.out.println(list);
//        Collections.reverse(list);
//        System.out.println(list);
//        Collections.shuffle(list);
//        Collections.sort(list);
//        Collections.swap(list,1,2);
        System.out.println(Collections.frequency(list, 123));
        System.out.println(list);
    }
    @Test
    public void copy(){
        List list = new ArrayList();
        list.add(123);
        list.add(45);
        list.add(56);
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);
    }
    @Test
    public void test3(){
        List list = new ArrayList();
        list.add(123);
        list.add(45);
        list.add(56);
        List list1 = Collections.synchronizedList(list);
        TreeSet treeSet = new TreeSet();
    }
}
