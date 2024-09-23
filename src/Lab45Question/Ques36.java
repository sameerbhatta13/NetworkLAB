package Lab45Question;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ques36 {

    public static void main(String[] args) {
        try {
          
            DatagramSocket socket = new DatagramSocket(9876);
            int localPort = socket.getLocalPort();
            System.out.println("Local Port: " + localPort);

            InetAddress localAddress = socket.getLocalAddress();
            System.out.println("Local Address: " + localAddress.getHostAddress());

            boolean isBound = socket.isBound();
            System.out.println("Is Socket Bound? " + isBound);
            
            boolean isConnected = socket.isConnected();
            System.out.println("Is Socket Connected? " + isConnected);

            socket.setSoTimeout(5000);  
            int timeout = socket.getSoTimeout();
            System.out.println("Socket Timeout: " + timeout + " milliseconds");
            
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

