import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author clown
 * @Date 2021/2/22 0022 0:13
 */
public class UrlTest {
    @Test
    public void testUrl() throws IOException {
        URL url = new URL("http://localhost:8080/examples/hello.txt");
        String protocol = url.getProtocol();
        System.out.println("协议名 = " + protocol);

        String host = url.getHost();
        System.out.println("主机名 = " + host);

        int port = url.getPort();
        System.out.println("端口号 = " + port);

        String path = url.getPath();
        System.out.println(path);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("hello.txt");
        int len;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }
        fileOutputStream.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
