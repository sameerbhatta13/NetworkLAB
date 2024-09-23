package Lab45Question;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Ques43Server {
    public static void main(String[] args) throws Exception {
        MulticastSocket multicastSocket = new MulticastSocket(); // Create a multicast socket
        InetAddress group = InetAddress.getByName("230.0.0.0"); // Multicast group address (must be in the range 224.0.0.0 - 239.255.255.255)
        
        String message = "Hello, Multicast Clients!";
        byte[] buffer = message.getBytes();
        
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 6789); // Send to group at port 6789
        
        multicastSocket.send(packet); // Send the packet to the group
        System.out.println("Message sent to multicast group: " + message);
        
        multicastSocket.close(); // Close the socket
    }
}

