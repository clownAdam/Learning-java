package cn.clown.reflect.task1;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author clown
 */
public class ReflectionTest {
    //TODO:反射之前,对于person类的操作
    @Test
    public void test1() {
        //1.创建person类的对象--person类的实例化
        Person p1 = new Person("tom", 12);
        //2.通过对象调用其内部的属性，方法
        p1.age = 10;
        System.out.println(p1);
        p1.show();
        /*在person类的外部，不可以通过person类的对象调用其内部私有结构;比如name属性，showNation()方法以及私有的构造器*/
    }

    //TODO:反射之后,对于person类的操作
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;
        //1.通过反射创建person类的对象
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
        Person person = cons.newInstance("tom", 12);
        System.out.println(person.toString());
        //2.通过反射，调用对象指定的属性和指定的方法
        Field age = clazz.getDeclaredField("age");
        age.set(person, 10);
        System.out.println(person);
        //3.调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);
        System.out.println("**********************************");
        /*通过反射，可以调用person类的私有结构，比如私有的构造器，属性，方法*/
        //1.私有构造器
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = cons1.newInstance("jerry");
        System.out.println(p1.toString());
        //2.私有属性name
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"hanmeimei");
        System.out.println(p1);
        //3.私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);
    }
    /**
     * 疑问1：通过直接new的方式或反射的方式都可以调用公共的结构,开发中到底用哪个？
     *      建议：使用new的方式.
     *    什么时候会使用反射的方式：
     *         反射的特征：动态性
     *         在编译时不能确定需要new的对象.
     * 疑问2：反射机制与面向对象的封装性是否矛盾？如何看待这两个技术？
     *      不矛盾.封装性建议怎样调用,反射解决能否调用.
     */
    //TODO:Class实例的获取(4种方式)
    /**/
    @Test
    public void test3() throws ClassNotFoundException {
        //TODO.方式一:调用运行时类的属性.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //TODO.方式二:通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //TODO.方式三：调用Class的静态方法:forName(String classPath)
        Class<?> clazz3 = Class.forName("cn.clown.reflect.task1.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        //TODO.方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("cn.clown.reflect.task1.Person");
        System.out.println(clazz4);

    }

}
