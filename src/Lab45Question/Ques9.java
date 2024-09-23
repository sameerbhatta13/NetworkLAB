package Lab45Question;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Ques9 {
    public static void main(String[] args) {
        try {
            // Use the factory method to get all network interfaces
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            // Iterate through the network interfaces
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                
                // Use getter methods to retrieve information about the network interface
                System.out.println("Interface Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());
                
                // Get and display the MAC address
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    StringBuilder macAddress = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    System.out.println("MAC Address: " + macAddress.toString());
                } else {
                    System.out.println("MAC Address: Not available");
                }

                // Display associated IP addresses
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress ip = inetAddresses.nextElement();
                    System.out.println("IP Address: " + ip.getHostAddress());
                }
                System.out.println("---------------------------");
            }

        } catch (SocketException e) {
            System.out.println("Error retrieving network interfaces: " + e.getMessage());
        }
    }
}

