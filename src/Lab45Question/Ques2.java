package Lab45Question;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ques2 {
    public static void main(String[] args) {
        try {
//            // Get the InetAddress object for the local host
//            InetAddress localHost = InetAddress.getLocalHost();
//            System.out.println("Local Host:");
//            displayInetAddressDetails(localHost);

            // Get the InetAddress object for a domain (example: google.com)
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("\nGoogle Host:");
            displayInetAddressDetails(google);

            // Get all IP addresses associated with a domain (example: google.com)
//            InetAddress[] googleAll = InetAddress.getAllByName("www.google.com");
//            System.out.println("\nAll Google IPs:");
//            for (InetAddress ip : googleAll) {
//                displayInetAddressDetails(ip);
//            }

        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve host: " + e.getMessage());
        }
    }

    // Method to display details using InetAddress getter methods
    public static void displayInetAddressDetails(InetAddress inetAddress) {
        System.out.println("Canonical Hostname: " + inetAddress.getCanonicalHostName());
        System.out.println("Host Address: " + inetAddress.getHostAddress());
        System.out.println("Host Name: " + inetAddress.getHostName());
        System.out.println("Is Any Local Address: " + inetAddress.isAnyLocalAddress());
        System.out.println("Is Link Local Address: " + inetAddress.isLinkLocalAddress());
        System.out.println("Is Loopback Address: " + inetAddress.isLoopbackAddress());
        System.out.println("Is Multicast Address: " + inetAddress.isMulticastAddress());
        System.out.println("Is Site Local Address: " + inetAddress.isSiteLocalAddress());
    }
}

