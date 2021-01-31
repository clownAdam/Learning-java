package cn.clown.reflect;

import cn.clown.reflect.task2.Person;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定结构:属性、方法、构造器
 * @author clown
 */
public class ReflectionTest {
    private Class<Person> clazz;
    private Person person;
    @Before
    public void before() throws Exception {
        clazz = Person.class;
        //创建运行时类对象
        person = clazz.newInstance();
    }

    /**
     * getField():只能获取当前类及父类中属性权限为public
     * @throws Exception
     */
    @Test
    public void testField() throws Exception {
        Class<Person> clazz = Person.class;
        //创建运行时类对象
        Person person = clazz.newInstance();
        //获取指定的属性
        Field id = clazz.getField("id");
        //设置当前属性的值
        id.set(person,1001);
        //获取当前属性的值
        System.out.println(id.get(person));

        System.out.println(person);
    }

    /**
     * getDeclaredField():获取当前类中指定变量名的属性.
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Field name = clazz.getDeclaredField("name");
        //设置能访问.
        name.setAccessible(true);
        //设置指定对象的属性值
        name.set(person,"tom");
        System.out.println(name.get(person));
    }

    @Test
    public void testMethod() throws Exception {
        //获取指定的方法
        Method show = clazz.getDeclaredMethod("show",String.class);
        show.setAccessible(true);
        //invoke:
        Object china = show.invoke(person, "china");
        System.out.println(china);
    }

    @Test
    public void testStaticMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        showDesc.invoke(person);
    }

    @Test
    public void testConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person tom = constructor.newInstance("tom");
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(tom, 199);
        System.out.println(tom);
    }
}
