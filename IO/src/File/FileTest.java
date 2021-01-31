package File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * File类的使用：
 * File类的一个对象,代表一个文件夹/文件
 *
 * @author clown
 * @Date 2020/12/3 0003 21:36
 */
public class FileTest {
    @Test
    public void test() {
        File file = new File("hello.txt");
        File file1 = new File("D:\\Application\\JetBrains\\space\\idea\\Learning-java\\IO\\hello.txt");
        System.out.println(file);
        System.out.println(file1);

        File file2 = new File("D:\\Application\\JetBrains\\space\\idea\\Learning-java", "IO");
        System.out.println(file2);

        File file3 = new File(file2, "hello.txt");
        System.out.println(file3);
    }

    @Test
    public void test2() {
        /*TODO
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\sparse.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
        System.out.println(new Date(1550910351445L));*/

        System.out.println("----------------------");
        File file = new File("D:\\com");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------------");
        File[] files = file.listFiles();
        File[] files1 = files;
        for (File file3 : files1) {
            System.out.println(file3);
        }
    }

    @Test
    public void test3() {
        File file1 = new File("D:\\sparse1.txt");
        File file2 = new File("hello.txt");
        System.out.println(file1.renameTo(file2));
    }

    @Test
    public void test5() {
        File file = new File("hello1.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
        System.out.println(file.isAbsolute());

    }

    /**
     * 创建硬盘中的文件或文件目录
     */
    @Test
    public void test6() throws IOException {
        File file = new File("hi.txt");
        if (file.exists()) {
            System.out.println("文件存在");
            System.out.println("删除文件");
            file.delete();
        } else {
            boolean newFile = file.createNewFile();
            System.out.println("创建成功");
        }
    }

    @Test
    public void test7() {
        String pathName = "";
        File file = new File("a\\b\\c");
        boolean mkdir = file.mkdirs();
        if (mkdir) {
            System.out.println("创建成功");
        }
    }

    @Test
    public void test8() {
        File file = new File("E:\\尚硅谷宋红康Java核心基础_好评如潮\\Java基础全套视频教程\\day27_IO流与网络编程");
        String[] list = file.list();
        for (String s : list) {
            boolean b = s.endsWith(".avi");
            if (b) {
                System.out.println(s);
            } else {
                System.out.println("error:" + s);
            }
        }
    }

    static int count = 0;

    @Test
    public void test9() {
        File file = new File("E:\\尚硅谷宋红康Java核心基础_好评如潮\\Java基础全套视频教程");
        printSubFile(file);
        System.out.println(count);
    }

    public void printSubFile(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                printSubFile(file1);
            } else {
                System.out.println(file1.getPath());
                count += file1.length();
                System.out.println(file1.getAbsoluteFile());
            }
        }
    }

    @Test
    public void test10() {
        File a = new File("a");
        deleteSubFile(a);
    }

    public void deleteSubFile(File file) {
        if (file.isDirectory() && file.list().length != 0) {
            File[] list = file.listFiles();
            for (File s : list) {
                deleteSubFile(s);
            }
        }
        file.delete();

    }
}
