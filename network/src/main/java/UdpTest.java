import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP
 *
 * @author clown
 * @Date 2021/2/21 0021 23:11
 */
public class UdpTest {
    @Test
    public void sender() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String message = "i'm udp,³ÂË¼Æë";
        byte[] data = message.getBytes();
        InetAddress address = InetAddress.getLocalHost();
        int port = 8889;
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, address, port);
        datagramSocket.send(packet);
        datagramSocket.close();
    }

    @Test
    public void receiver() throws IOException {
        int port = 8889;
        DatagramSocket datagramSocket = new DatagramSocket(port);
        byte[] buffer = new byte[50];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        datagramSocket.receive(packet);
        byte[] data = packet.getData();
        String s = new String(data);
        System.out.println(s);
        datagramSocket.close();
    }
}
