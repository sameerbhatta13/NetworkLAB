package Lab45Question;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Ques6 {
    public static void main(String[] args) {
        try {
            // Get the local host IP address (Your system's IP address)
            InetAddress ipAddress = InetAddress.getLocalHost();
            System.out.println("IP Address: " + ipAddress.getHostAddress());

            // Get the network interface for the IP address
            NetworkInterface network = NetworkInterface.getByInetAddress(ipAddress);

            // Get the MAC address as a byte array
            byte[] macAddressBytes = network.getHardwareAddress();

            // Convert the MAC address bytes into a readable string
            if (macAddressBytes != null) {
                StringBuilder macAddress = new StringBuilder();
                for (int i = 0; i < macAddressBytes.length; i++) {
                    macAddress.append(String.format("%02X%s", macAddressBytes[i], (i < macAddressBytes.length - 1) ? "-" : ""));
                }
                System.out.println("MAC Address: " + macAddress.toString());
            } else {
                System.out.println("MAC Address not available.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Unable to get IP address: " + e.getMessage());
        } catch (SocketException e) {
            System.out.println("Unable to get MAC address: " + e.getMessage());
        }
    }
}

