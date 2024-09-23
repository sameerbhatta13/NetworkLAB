package Lab45Question;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Ques38Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] buffer = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(receivePacket);  // Receive message

            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received: " + message);

            DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getLength(),
                    receivePacket.getAddress(), receivePacket.getPort());
            serverSocket.send(sendPacket);  // Echo message back
        }
    }
}

