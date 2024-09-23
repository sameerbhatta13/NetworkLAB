package Lab45Question;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ques3 {
    public static void main(String[] args) {
        try {
            // You can replace "www.google.com" with any domain or IP address string
            InetAddress address = InetAddress.getByName("127.0.0.1"); // Example: loopback address
            System.out.println("Address: " + address.getHostAddress());
            
            // Display characteristics of the IP address
            printAddressCharacteristics(address);

        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve host: " + e.getMessage());
        }
    }

    // Method to check and print the characteristics of the IP address
    public static void printAddressCharacteristics(InetAddress address) {
        System.out.println("Is Any Local Address: " + address.isAnyLocalAddress());
        System.out.println("Is Link Local Address: " + address.isLinkLocalAddress());
        System.out.println("Is Loopback Address: " + address.isLoopbackAddress());
        System.out.println("Is Multicast Address: " + address.isMulticastAddress());
        System.out.println("Is Site Local Address: " + address.isSiteLocalAddress());
    }
}
