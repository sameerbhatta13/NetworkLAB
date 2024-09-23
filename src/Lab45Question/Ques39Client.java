package Lab45Question;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ques39Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");

        // Send empty request to server
        byte[] sendBuffer = new byte[1];
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 9876);
        clientSocket.send(sendPacket);

        // Receive the server's response
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        clientSocket.receive(receivePacket);

        // Display the received date and time
        String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Current Date and Time from Server: " + serverResponse);

        clientSocket.close();
    }
}

