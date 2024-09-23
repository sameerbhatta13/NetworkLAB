package Lab45Question;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ques12 {
    public static void main(String[] args) throws IOException {
        String host = "google.com"; // Test with Google or change to another host
        
        // Check TCP support on port 80 (HTTP)
        try (Socket tcpSocket = new Socket(host, 80)) {
            System.out.println("TCP supported on port 80");
        } catch (IOException e) {
            System.out.println("TCP not supported on port 80");
        }

        // Check UDP support on port 53 (DNS)
        try (DatagramSocket udpSocket = new DatagramSocket()) {
            udpSocket.connect(InetAddress.getByName(host), 53);
            System.out.println("UDP supported on port 53");
        } catch (IOException e) {
            System.out.println("UDP not supported on port 53");
        }

        // Check ICMP (Ping) support
        if (InetAddress.getByName(host).isReachable(5000)) {
            System.out.println("ICMP (Ping) supported");
        } else {
            System.out.println("ICMP (Ping) not supported");
        }
    }
}
