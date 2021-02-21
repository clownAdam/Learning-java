package object;

import java.io.Serializable;

/**
 * Person序列化：
 * 1.实现Serializable
 * 2.serialVersionUID
 * 3.属性必须都是可序列化
 * @author clown
 * @Date 2021/1/31 0031 17:51
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 156481613165L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
