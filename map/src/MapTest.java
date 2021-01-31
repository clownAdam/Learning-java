import org.junit.Test;

import java.util.*;

/**
 * Map:存储的是双列数据
 * 存储具有key-value键值对的数据.
 *
 * @author clown
 */
public class MapTest {
    @Test
    public void test() {
        HashMap hashMap = new HashMap();
        hashMap.put(null, null);
        hashMap.put(null, 1);
        System.out.println(hashMap);
    }

    @Test
    public void test2() {
        LinkedHashMap map = new LinkedHashMap();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map);
    }

    @Test
    public void test3() {
        Map map = new HashMap(16);
        map.put("ABC", 123);
        map.put(3, 3);
        map.put(2, 2);
        map.put(-1, -1);
        map.put(-1, 3);
        System.out.println(map);
        map.remove(3);
        System.out.println(map);
//        map.clear();
//        System.out.println(map.size());
        System.out.println(map.get("ABC"));
        System.out.println(map.containsKey("ABC"));
        System.out.println(map.containsValue(3));

    }

    @Test
    public void testMethod() {
        HashMap map = new HashMap();
        map.put("aa", 123);
        map.put(1, 2);
        map.put("aa", 456);
        System.out.println(map);
        HashMap map1 = new HashMap();
        map.put("aa2", 123);
        map.put(12, 2);
        map.put("a2a", 456);
        map.putAll(map1);
        System.out.println(map);

        //remove
        map.remove("456");
        System.out.println(map);

        map.clear();
        System.out.println(map);
        System.out.println(map.size());
    }

    @Test
    public void test5() {
        HashMap map = new HashMap();
        map.put("aa2", 123);
        map.put(12, 2);
        map.put("a2a", 456);
        System.out.println(map.get(12));
        System.out.println(map.containsKey(12));
        System.out.println(map.containsValue(123));
    }

    @Test
    public void test6() {
        HashMap map = new HashMap();
        map.put("aa2", 123);
        map.put(12, 2);
        map.put("a2a", 456);
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Collection values = map.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        values.forEach(System.out::println);
        for (Object value : values) {
            System.out.println(value);
        }
    }

    @Test
    public void test7() {
        HashMap map = new HashMap();
        map.put("aa2", 123);
        map.put(12, 2);
        map.put("a2a", 456);
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getKey() + "--" + next.getValue());
        }

    }
    @Test
    public void testTreeMap(){
        TreeMap treeMap = new TreeMap();
        User user = new User();
    }
}
