package Lab45Question;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ques38Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");

        String message = "Hello, Server!";
        byte[] sendBuffer = message.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 9876);
        clientSocket.send(sendPacket);  // Send message to server

        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        clientSocket.receive(receivePacket);  // Receive echo from server

        System.out.println("Echoed: " + new String(receivePacket.getData(), 0, receivePacket.getLength()));
        clientSocket.close();
    }
}
