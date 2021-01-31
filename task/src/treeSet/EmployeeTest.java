package treeSet;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author clown
 */
public class EmployeeTest {
    @Test
    public void test() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee employee1 = (Employee) o1;
                    Employee employee2 = (Employee) o2;
                    MyDate birthday1 = employee1.getBirthday();
                    MyDate birthday2 = employee2.getBirthday();
                    int minusYear = birthday1.getYear() - birthday2.getYear();
                    if (minusYear != 0) {
                        return minusYear;
                    }
                    int minuxMonth = birthday1.getMonth() - birthday2.getMonth();
                    if (minusYear != 0) {
                        return minuxMonth;
                    }
                    return birthday1.getDay() - birthday2.getDay();
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        TreeSet treeSet = new TreeSet(comparator);

        Employee employee1 = new Employee("clown1", 22, new MyDate(2459, 5, 23));
        Employee employee = new Employee("clown", 21, new MyDate(1999, 2, 22));
        Employee employee2 = new Employee("clown2", 23, new MyDate(1999, 3, 32));

        treeSet.add(employee);
        treeSet.add(employee1);
        treeSet.add(employee2);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
