package Lab45Question;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Ques41Server {

    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer;

        System.out.println("UDP Armstrong Server is running...");

        while (true) {
            // Receive the number from the client
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);
            String numberStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
            int number = Integer.parseInt(numberStr.trim());

            // Check if the number is Armstrong
            String result = isArmstrong(number) ? number + " is an Armstrong number." : number + " is not an Armstrong number.";


            sendBuffer = result.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
            serverSocket.send(sendPacket);
        }
    }
    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        int digits = Integer.toString(num).length();

        while (num != 0) {
            int remainder = num % 10;
            sum += Math.pow(remainder, digits);
            num /= 10;
        }
        return sum == originalNum;
    }
}

