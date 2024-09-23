package Lab45Question;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Ques40Server {

    public static void main(String[] args) throws Exception {
        // Create a DatagramSocket to listen on port 9876
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveBuffer = new byte[1024];

        System.out.println("UDP Server is running and waiting for a message...");

        // Receive packet from client
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        serverSocket.receive(receivePacket);

        // Extract data from packet
        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received message: " + message);

        // Close the socket
        serverSocket.close();
    }
}

