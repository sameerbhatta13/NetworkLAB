package Lab45Question;

import java.io.*;
import java.net.*;

public class Ques32 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            
            // Set socket option
            socket.setSoTimeout(5000); 
            socket.setReuseAddress(true); 
            
            // Connect to the server at localhost on port 6789
            socket.connect(new InetSocketAddress("localhost", 6789), 5000); // 5-second connection timeout
            
            // Enable TCP_NODELAY to disable Nagle's algorithm
            socket.setTcpNoDelay(true);

            // Display the options that have been set
            System.out.println("SO_TIMEOUT: " + socket.getSoTimeout());
            System.out.println("SO_REUSEADDR: " + socket.getReuseAddress());
            System.out.println("TCP_NODELAY: " + socket.getTcpNoDelay());

            // Sending data to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from client with custom socket options!");

            // Receiving data from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = in.readLine();
            System.out.println("Server response: " + serverResponse);

            // Close the socket
            socket.close();

        } catch (SocketTimeoutException e) {
            System.out.println("Connection timed out!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

