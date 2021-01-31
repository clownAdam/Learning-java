import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用 1.5
 *
 * @author clown
 */
public class GenericTest {
    @Test
    public void test(){
        List<Integer> list = new ArrayList();
        list.add(12);
        list.add(24);
        list.add(56);
        list.add(88);


        for (Object score : list) {
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }
    @Test
    public void test2(){
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(23);
        Iterator<Integer> iterator = integerArrayList.iterator();
    }
    @Test
    public void test3(){
        HashMap<String, Integer> map = new HashMap<>(90);
        Integer tom = map.put("tom", 2);
        Integer tom2 = map.put("tom", 2);
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }
    }

    @Test
    public void test4(){

    }
}














