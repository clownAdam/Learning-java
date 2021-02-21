import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author clown
 * @Date 2021/2/20 0020 1:22
 */
public class TcpTest {
    @Test
    public void client() throws IOException {
        InetAddress localhost = InetAddress.getByName("localhost");
        Socket socket = new Socket(localhost, 8899);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,i am client³ÂË¼Æë".getBytes());

        outputStream.close();
        socket.close();

    }

    @Test
    public void server() throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(8899);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[5];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }
        System.out.println(byteArrayOutputStream.toString());
        System.out.println(accept.getInetAddress().getHostAddress());
        byteArrayOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
