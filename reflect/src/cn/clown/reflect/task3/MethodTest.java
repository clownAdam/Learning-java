package cn.clown.reflect.task3;

import cn.clown.reflect.task2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * 运行时类的方法结构
 * @author clown
 */
public class MethodTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        //getDeclaredMethods():获取当前运行时类中声明的所有方法,不包含父类中声明的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    @Test
    public void test2(){
        //获取方法声明的注解
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            Annotation[] mAnnotations = m.getAnnotations();
            for (Annotation annotation : mAnnotations) {
                System.out.println(annotation);
            }

            int modifiers = m.getModifiers();
            System.out.println(Modifier.toString(modifiers));

            Class<?> type = m.getReturnType();
            System.out.println(type.getName());
            System.out.println(m.getName());
            for (Parameter parameter : m.getParameters()) {
                System.out.println(parameter);
            }

            Class<?>[] exceptionTypes = m.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println(exceptionType);
            }
        }

    }
}
