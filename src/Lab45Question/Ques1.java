package Lab45Question;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ques1 {
	 public static void main(String[] args) {
	        try {
	            // Get the IP address of the local host (your system)
	            InetAddress ip = InetAddress.getLocalHost();
	            
	            // Display the IP address
	            System.out.println("Your IP address is: " + ip.getHostAddress());
	        } catch (UnknownHostException e) {
	            System.out.println("Unable to get IP address: " + e.getMessage());
	        }
	    }
}
