package Lab45Question;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Ques41Client {

    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        byte[] sendBuffer;
        byte[] receiveBuffer = new byte[1024];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check if it is an Armstrong number: ");
        int number = scanner.nextInt();

        // Send the number to the server
        String numberStr = String.valueOf(number);
        sendBuffer = numberStr.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 9876);
        clientSocket.send(sendPacket);

        // Receive the result from the server
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        clientSocket.receive(receivePacket);

        // Display the result
        String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Server says: " + serverResponse);

        // Close the socket
        clientSocket.close();
    }
}

