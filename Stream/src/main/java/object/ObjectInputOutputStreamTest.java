package object;

import org.junit.Test;

import java.io.*;

/**
 * @author clown
 * @Date 2021/1/31 0031 17:21
 */
public class ObjectInputOutputStreamTest {
    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或者通过网络传输出去
     * 使用ObjectOutputSteam实现
     */
    @Test
    public void testObjectOutputStream() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.dat"))) {
            oos.writeObject(new String("i love beijing TianAnMen"));
            oos.flush();
            oos.writeObject(new Person("王明",23));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化：将磁盘文件中的对象还原为内存中的Java对象.
     * ObjectInputStreame
     */
    @Test
    public void testObjectInputStream(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.dat"))) {
            Object data = ois.readObject();
            System.out.println("data = " + data);
            Person person = (Person) ois.readObject();
            System.out.println("person = " + person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
