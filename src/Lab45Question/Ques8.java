package Lab45Question;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Ques8 {
    public static void main(String[] args) {
        try {
            // Provide the IP address (you can change this to any IP)
            InetAddress ipAddress = InetAddress.getByName("192.168.1.101"); // Example IP address
            
            // Get the network interface associated with the IP address
            NetworkInterface network = NetworkInterface.getByInetAddress(ipAddress);
            
            // Get the MAC address as a byte array
            byte[] mac = network.getHardwareAddress();
            
            // Convert the MAC address byte array into a readable format
            if (mac != null) {
                StringBuilder macAddress = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                System.out.println("MAC Address: " + macAddress.toString());
            } else {
                System.out.println("MAC Address not found for the provided IP.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
        } catch (SocketException e) {
            System.out.println("Socket exception: " + e.getMessage());
        }
    }
}
