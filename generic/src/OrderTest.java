import org.junit.Test;

/**
 * @author clown
 */
public class OrderTest {
    @Test
    public void test1() {
        Order<Object> order = new Order<>();
        order.setOrderT(123);
        order.setOrderT("123");

        Order<String> order1 = new Order<>("orderAA", 1001, "order:AA");

        order1.setOrderT("AA:hello");

    }

    @Test
    public void test2() {
        SubOrder<Integer> subOrder = new SubOrder();
        subOrder.setOrderT(1);
    }
}
