package object;

import org.junit.Test;

import java.io.*;

/**
 * @author clown
 * @Date 2021/1/31 0031 17:21
 */
public class ObjectInputOutputStreamTest {
    /**
     * ���л����̣����ڴ��е�java���󱣴浽�����л���ͨ�����紫���ȥ
     * ʹ��ObjectOutputSteamʵ��
     */
    @Test
    public void testObjectOutputStream() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.dat"))) {
            oos.writeObject(new String("i love beijing TianAnMen"));
            oos.flush();
            oos.writeObject(new Person("����",23));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �����л����������ļ��еĶ���ԭΪ�ڴ��е�Java����.
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
