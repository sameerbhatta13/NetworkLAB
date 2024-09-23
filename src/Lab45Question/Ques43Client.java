package Lab45Question;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Ques43Client {
	  public static void main(String[] args) throws Exception {
	        MulticastSocket multicastSocket = new MulticastSocket(6789); // Join the multicast group on port 6789
	        InetAddress group = InetAddress.getByName("230.0.0.0"); // Multicast group address
	        
	        multicastSocket.joinGroup(group); // Join the multicast group
	        
	        byte[] buffer = new byte[1024];
	        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	        
	        System.out.println("Waiting for messages from the multicast group...");
	        
	        // Receive a packet from the multicast group
	        multicastSocket.receive(packet);
	        String receivedMessage = new String(packet.getData(), 0, packet.getLength());
	        
	        System.out.println("Message received from multicast group: " + receivedMessage);
	        
	        multicastSocket.leaveGroup(group); // Leave the multicast group
	        multicastSocket.close(); // Close the socket
	    }
}

