package Lab45Question;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Ques7 {
    public static void main(String[] args) {
        try {
            // Retrieve all network interfaces on the system
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            
            // Loop through the interfaces
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface network = networkInterfaces.nextElement();
                
                // Get the MAC address of the network interface
                byte[] mac = network.getHardwareAddress();
                
                // If MAC address exists, convert it to a string and print
                if (mac != null) {
                    StringBuilder macAddress = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    System.out.println("MAC Address: " + macAddress.toString());

                    // Get and print the associated IP addresses
                    Enumeration<InetAddress> inetAddresses = network.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress ip = inetAddresses.nextElement();
                        System.out.println("Associated IP Address: " + ip.getHostAddress());
                    }
                    System.out.println("---------------------------");
                }
            }
        } catch (SocketException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
