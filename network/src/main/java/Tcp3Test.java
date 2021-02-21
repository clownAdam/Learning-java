import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author clown
 * @Date 2021/2/20 0020 14:59
 */
public class Tcp3Test {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("localhost"), 8889);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream("demo");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }


        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] cache = new byte[1024];
        int len1;
        while ((len1 = inputStream.read(cache)) != -1) {
            byteArrayOutputStream.write(cache, 0, len1);
        }
        System.out.println(byteArrayOutputStream.toString());
        byteArrayOutputStream.close();
        inputStream.close();
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8889);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("write2");
        int len;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }


        //服务器端反馈
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("success,接收成功".getBytes());
        fileOutputStream.close();
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
