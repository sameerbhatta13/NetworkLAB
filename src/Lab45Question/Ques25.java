package Lab45Question;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Ques25 {
    public static void main(String[] args) {
        String host = "www.google.com"; // Replace with the desired host
        int port = 80;                  

        try {
                      Socket socket = new Socket(host, port);

            // Get local address and port
            InetAddress localAddress = socket.getLocalAddress();
            int localPort = socket.getLocalPort();

            // Get remote address and port
            InetAddress remoteAddress = socket.getInetAddress();
            int remotePort = socket.getPort();

            // Display the information
            System.out.println("Local Address: " + localAddress.getHostAddress());
            System.out.println("Local Port: " + localPort);
            System.out.println("Remote Address: " + remoteAddress.getHostAddress());
            System.out.println("Remote Port: " + remotePort);
 
            // Close the socket
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

