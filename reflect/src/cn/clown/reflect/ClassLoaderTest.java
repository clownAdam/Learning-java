package cn.clown.reflect;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ClassLoader
 * @author clown
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        System.out.println(parent.getParent());

        ClassLoader loader = String.class.getClassLoader();
    }
    /**
     * properties:读取配置文件
     * */
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        //TODO.1:读取配置文件
        /*
        //识别位置在工程下
       FileInputStream inputStream = new FileInputStream("resources/jdbc.properties");
       properties.load(inputStream);
        */
        //TODO.2:类加载器读取配置文件
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        /*识别未知在src下*/
        InputStream inputStream = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(inputStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        System.out.println(user+"---"+password);

    }
}
