package cn.clown.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 *
 * @author clown
 */
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");
    }
}

interface Human {
    /**
     * 获取信仰
     *
     * @return
     */
    String getBelief();

    /**
     * eat
     *
     * @param food
     * @return void
     */
    void eat(String food);
}

/**
 * 动态代理类
 */
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe i can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil {
    public void method1() {
        System.out.println("通用方法一");
    }

    public void method2() {
        System.out.println("通用方法二");
    }
}

class ProxyFactory {
    public static Object getProxyInstance(Object object) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(object);
        Object instance = Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                handler
        );
        return instance;
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object object;

    public void bind(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();
        Object invoke = method.invoke(object, args);
        return invoke;
    }
}