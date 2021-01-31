package cn.clown.reflect;

import cn.clown.reflect.task1.Person;
import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author clown
 */
public class NewInstanceTest {
    /**
     * @throws IllegalAccessException 非法访问异常
     * @throws InstantiationException 空参构造器异常
     */
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        /**
         * 调用newInstance()方法,创建对应的运行时类的对象.
         * 其内部调用了运行时类的空参构造器
         * 要正常的创建运行时类的对象要求：
         *      1.运行时类必须提供空参的构造器
         *      2.空参构造器的访问权限不能太小,通常设置为public.
         *  要求在Javabean中提供一个public的空参构造器,原因：
         *      1.便于通过反射，创建运行时类的对象
         *      2.便于自雷继承此运行时类时，默认调用super()时，保证父类有此构造器.
         */
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    /**
     * 反射的动态性
     */
    @Test
    public void test2() {
        int num = new Random().nextInt(3);
        System.out.println(num);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.util.Random";
                break;
            case 2:
                classPath = "cn.clown.reflect.task1.Person";
                break;
            default:
                System.out.println("default null");
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个指定类的对象
     *
     * @param classPath 类的全类名
     * @return 返回对象
     * @throws Exception
     */
    public Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        Object obj = clazz.newInstance();
        return obj;
    }

    /**
     * 获取运行时类的完整结构
     */
    @Test
    public void test3() {

    }
}
