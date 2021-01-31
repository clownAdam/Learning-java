import org.junit.Test;

import java.util.*;

/**
 * @author clown
 */
public class SetTest {
    /**
     * Set:数据无序,不可重复.Set接口中没有定义额外新的方法,使用的都是Collection中声明的方法。
     * >无序:并非随机性.底层也是数组实现,初识数组长度为16 ,而无序则指存放在数组中的顺序随机,一旦存放好则数组定型.
     * 即:存储的数据在底层数组中并非按照数组索引的顺序添加,而是根据数据的hash值决定.
     * >不可重复:保证添加的元素按照equals()判断时,不能返回true,即相同的元素只能添加一个.
     * <p>
     * >hash值:
     * <p>
     * >set添加元素的过程,以HashSet为例:
     * >>>当我们向HashSet中添加元素a,首先会调用元素a的hashCode()方法,计算a的hash值,
     * hash值通过某种算法计算出a在HashSet底层数组中的存放位置(即为:索引位置),判断数组此位置上是否已经有元素
     * 如果此位置上没有其他元素,则元素a直接添加成功;
     * 如果此位置上有其他元素b(或以链表形式存在的多个元素),则比较元素a与元素b的hash值
     * >>>>>>如果Hash值不相同,则元素a添加成功.
     * 元素a与已经存在指定索引位置上数据以链表的方式存储(jdk7:元素a放在数组中,指向原来的元素;jdk8:原来的元素在数组中,指向元素a).
     * >>>>>>如果hash值相同,进而需要调用元素a所在类的equals()方法.
     * equals()方法返回true,元素a添加失败.否则添加成功。
     * HashSet底层是数组加链表的结构
     */
    @Test
    public void test() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 12));
        set.add(new Person("Tom", 12));
        set.add(129);
        set.hashCode();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    /**
     * LinkedHashSet:
     */
    @Test
    public void test1() {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 12));
        set.add(new Person("Tom", 12));
        set.add(129);
        set.hashCode();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    /**
     * TreeSet:可以按照添加对象的指定属性进行排序,即添加的属性类型需一致
     * >>>向TreeSet中添加数据,要求是相同类的对象,才可以比较大小
     * >>>默认升序排序
     */
    @Test
    public void test2() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person("A", 12));
        treeSet.add(new Person("B", 10));
        treeSet.add(new Person("C", 9));
        treeSet.add(new Person("C", 2));
        System.out.println(treeSet);
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        Comparator compator = (o1, o2) -> {
            if (o1 instanceof Person && o2 instanceof Person) {
                Person p1 = (Person) o1;
                Person p2 = (Person) o2;
                return Integer.compare(p1.getAge(), p2.getAge());
            } else {
                throw new RuntimeException("数据类型不匹配");
            }
        };
        TreeSet treeSet = new TreeSet(compator);
        treeSet.add(new Person("A", 2));
        treeSet.add(new Person("B", 2));
        treeSet.add(new Person("C", 12));
        treeSet.add(new Person("C", 32));
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4() {
        List arrayList = new ArrayList();
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(-1);
        arrayList.add(-9);
        arrayList.add(3);
        arrayList.add(8);
        arrayList.add(88);
        List list = duplicateList(arrayList);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("*****************");
        Iterator iterator1 = arrayList.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }

    public static List duplicateList(List list) {
        Set hashSet = new LinkedHashSet();
        hashSet.addAll(list);
        return new ArrayList(hashSet);
    }

    //
    @Test
    public void test5() {
        HashSet hashSet = new HashSet();
        User p1 = new User(1001, "AA");
        User p2 = new User(1001, "AA");
        User p3 = new User(1002, "BB");

        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p3);

//        p1.setName("CC");

//        hashSet.remove(p1);
        System.out.println(hashSet);

//        hashSet.add(new User(1001, "CC"));
//        System.out.println(hashSet);
//
//        hashSet.add(new User(1001, "AA"));
//        System.out.println(hashSet);
    }
}
