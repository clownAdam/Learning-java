package cn.clown.reflect.task3;

import cn.clown.reflect.task2.MyAnnotation;
import cn.clown.reflect.task2.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author clown
 */
public class OtherTest {
    /**
     * 构造器
     */
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        //getDeclaredConstructors():获取当前运行时类中所有构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    /**
     * 运行时类的父类
     */
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /**
     * 获取运行时类的带泛型的父类
     */
    @Test
    public void test3(){
        Class<Person> clazz = Person.class;
        Type type = clazz.getGenericSuperclass();
        System.out.println(type);
    }
    /**
     * 获取运行时类的带泛型的父类的泛型
     */
    @Test
    public void test4(){
        Class<Person> clazz = Person.class;
        Type type = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        for (Type argument : typeArguments) {
            System.out.println(argument.getTypeName());
        }
    }
    /**
     * 获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }
    /**
     * 获取运行时类所在的包
     */
    @Test
    public void test6(){
        Class<Person> clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }
    /**
     * 获取运行时类的注解
     */
    @Test
    public void test7(){
        Class<Person> clazz = Person.class;
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.value());
    }
}
