package Lab1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
public class WebPageDownloader {
	 public static void main(String[] args) {
	        String host = "google.com";  // The website you want to download
	        int port = 80;  // Default HTTP port

	        try {
	            // Create a socket connected to the host on port 80
	            Socket socket = new Socket(host, port);

	            // Print socket properties
	            System.out.println("Connected to: " + socket.getInetAddress());
	            System.out.println("Remote Port: " + socket.getPort());
	            System.out.println("Local Address: " + socket.getLocalAddress());
	            System.out.println("Local Port: " + socket.getLocalPort());
	            System.out.println("Remote Socket Address: " + socket.getRemoteSocketAddress());
	            System.out.println("Local Socket Address: " + socket.getLocalSocketAddress());
	            System.out.println("Is Connected: " + socket.isConnected());
	            System.out.println("Is Closed: " + socket.isClosed());

	            // Send HTTP GET request
	            OutputStream outputStream = socket.getOutputStream();
	            String request = "GET / HTTP/1.1\r\n" +
	                             "Host: " + host + "\r\n" +
	                             "Connection: close\r\n" +
	                             "\r\n";
	            outputStream.write(request.getBytes());
	            outputStream.flush();

	            // Read the response
	            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            String line;
	            System.out.println("\n--- Web Page Content ---");
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }

	            // Close the socket
	            reader.close();
	            socket.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
