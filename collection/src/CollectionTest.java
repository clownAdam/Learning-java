import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * @author clown
 */
public class CollectionTest {
    /**
     * Collection接口中的方法的使用
     */
    @Test
    public void testCollection() {
        Collection collection = new ArrayList();

        //add
        collection.add("aa");
        collection.add(22);
        collection.add(new Date());
        System.out.println(collection.size());
        Collection collection1 = new ArrayList();
        collection1.add("aa");
        collection1.add(33);
        collection1.add(new Date());
        collection.addAll(collection1);
        System.out.println(collection.size());
        System.out.println(collection);
        //isEmpty()
        boolean empty = collection.isEmpty();
        System.out.println(empty);
        collection.clear();
        System.out.println(collection);
        System.out.println(empty);

    }

    @Test
    public void testCollection2() {
        //contains
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(false);
        collection.add(new String("tom"));
        Person jerry = new Person("jerry", 20);
        collection.add(jerry);
        boolean contains = collection.contains(123);
        System.out.println(contains);
        boolean tom = collection.contains(new String("tom"));
        System.out.println(tom);
        System.out.println(collection.add(new Person("jerry", 20)));
        System.out.println(collection.contains(new Person("jerry", 20)));
        System.out.println("****************");
        String str = new String("234");
        collection.add(str);
        System.out.println(collection);
        Collection integers = Arrays.asList(123, 456);
        System.out.println(collection.containsAll(integers));
    }

    @Test
    public void testRemoveCollection() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(false);
        collection.add(new Person("abc", 21));
        System.out.println(collection);
        Person abc = new Person("abc", 21);
        collection.remove(123);
        collection.remove(abc);
        System.out.println(collection);
    }

    @Test
    public void testRetain() {
        Collection collection = new ArrayList();
        Collection collection1 = Arrays.asList(123, 345, 6, 75, 4);
        collection.add(123);
        collection.add(456);
        collection.add(4);
        collection.add(false);
//        collection.retainAll(collection1);
//        System.out.println(collection);
        Collection arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add(4);
        arrayList.add(false);
        System.out.println(collection.equals(arrayList));
    }

    @Test
    public void testHashCode() {
        Collection collection = new ArrayList();
        Collection collection1 = Arrays.asList(123, 345, 6, 75, 4);
        collection.add(123);
        collection.add(456);
        collection.add(4);
        collection.add(false);
        collection.add(false);
        System.out.println(collection.hashCode());
        collection1.forEach(System.out::println);
        Object[] objects = collection.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
