import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * @author clown
 */
public class AnnotationTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("Person");
        MyAnnotationTest annotation = (MyAnnotationTest) clazz.getAnnotation(MyAnnotationTest.class);
        System.out.println(annotation.value());
        System.out.println("************************");
        Class<Student> studentClass = Student.class;
        for (Annotation annotation1 : new Person().getClass().getAnnotations()) {
            System.out.println(annotation1.annotationType().getSimpleName());
            System.out.println(annotation1.getClass().getName());
        }
        System.out.println("************************");
        Generic<String> stringGeneric = new Generic<>();
    }
}

@MyAnnotationTest
class Person {
    private String name;
    private int age;

    public Person() {
    }

    @MyAnnotationTest
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk() {
        System.out.println("人走路");
    }

    public void eat() {
        System.out.println("人吃饭");
    }
}

interface Info {
    /**
     * show:显示
     */
    void show();
}

class Student extends Person implements Info {
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}

class Generic<@MyAnnotationTest T> {
    public void show() throws @MyAnnotationTest RuntimeException{
        ArrayList<@MyAnnotationTest String> list = new ArrayList<>();

    }
}