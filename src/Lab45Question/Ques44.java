package Lab45Question;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Ques44 {

    public static void main(String[] args) {
        try {
            // Create a MulticastSocket bound to the specified port
            int port = 6789;
            String multicastGroup = "230.0.0.0"; // Multicast group address
            
            MulticastSocket socket = new MulticastSocket(port); // Bind to port 6789
            InetAddress group = InetAddress.getByName(multicastGroup);

            // Join the multicast group
            socket.joinGroup(group);
            System.out.println("Joined multicast group: " + multicastGroup + " on port: " + port);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Listen indefinitely for packets
            while (true) {
                // Receive multicast packet
                socket.receive(packet);
                String receivedData = new String(packet.getData(), 0, packet.getLength());

                // Print the received message and sender's information
                System.out.println("Received packet from: " + packet.getAddress().getHostAddress());
                System.out.println("Message: " + receivedData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

