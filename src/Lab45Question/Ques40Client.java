package Lab45Question;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ques40Client {

    public static void main(String[] args) throws Exception {
        // Create a DatagramSocket to send the message
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");

        // Prepare the message to be sent
        String message = "Hello, UDP Server!";
        byte[] sendBuffer = message.getBytes();

        // Send the message to the server at port 9876
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 9876);
        clientSocket.send(sendPacket);
        System.out.println("Message sent to server: " + message);

        // Close the socket
        clientSocket.close();
    }
}
