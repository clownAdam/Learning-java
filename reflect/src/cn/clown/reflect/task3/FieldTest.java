package cn.clown.reflect.task3;

import cn.clown.reflect.task2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * 获取当前运行时类的属性结构
 * @author clown
 */
public class FieldTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        //获取属性结构
        //getFields()能获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("=========================");
        //getDeclaredFields():获取当前运行时类中声明的所有属性,不包含父类中声明的属性.
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(Modifier.toString(modifiers));
            //2.数据类型
            Class<?> type = f.getType();
            System.out.println(type);
            //3.变量名
            String name = f.getName();
            System.out.println(name);
        }
    }
}
