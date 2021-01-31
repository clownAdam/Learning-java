
import java.lang.annotation.*;

/**
 * @author Administrator
 */
//@Repeatable(MyAnnotationTest1.class)
@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationTest {
    String value() default "clown";
}
