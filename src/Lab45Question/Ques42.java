package Lab45Question;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;

public class Ques42 {

    public static void main(String[] args) throws Exception {
       
        DatagramSocket socket = new DatagramSocket();

        // Set socket options
        socket.setSoTimeout(5000); 
        socket.setReceiveBufferSize(8192); 
        socket.setSendBufferSize(8192); 
        socket.setReuseAddress(true); 
        
        // Display socket options
        System.out.println("Receive Buffer Size: " + socket.getReceiveBufferSize());
        System.out.println("Send Buffer Size: " + socket.getSendBufferSize());
        System.out.println("Reuse Address: " + socket.getReuseAddress());
        System.out.println("Timeout: " + socket.getSoTimeout());

   
        InetAddress serverAddress = InetAddress.getByName("localhost");
        String message = "Hello, UDP Server!";
        byte[] sendBuffer = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 9876);
        socket.send(sendPacket); // Send the packet

        // Receive a response from the server
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        try {
            socket.receive(receivePacket); // Receive the packet (with a timeout)
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received message from server: " + response);
        } catch (java.net.SocketTimeoutException e) {
            System.out.println("Timeout reached, no response received.");
        }

        // Close the socket
        socket.close();
    }
}

