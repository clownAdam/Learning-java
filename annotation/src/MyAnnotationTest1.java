import java.lang.annotation.*;

/**
 * @author Administrator
 */
@Target({ElementType.TYPE,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationTest1 {
    MyAnnotationTest[] value() ;
}
