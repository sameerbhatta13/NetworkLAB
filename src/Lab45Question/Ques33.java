package Lab45Question;

import java.io.*;
import java.net.*;

public class Ques33 {
    public static void main(String[] args) {
        try {
           
            ServerSocket serverSocket = new ServerSocket();

            // Set server socket options before binding and accepting connections
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(6789)); 
            serverSocket.setSoTimeout(10000);
            
            System.out.println("Server is waiting for client connection...");
            
            System.out.println("SO_TIMEOUT: " + serverSocket.getSoTimeout());
            System.out.println("SO_REUSEADDR: " + serverSocket.getReuseAddress());

            try {
              
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Set socket options for the accepted client socket
                clientSocket.setTcpNoDelay(true); 

                // Display the options set on both server and client sockets
                System.out.println("ServerSocket SO_REUSEADDR: " + serverSocket.getReuseAddress());
                System.out.println("Client Socket TCP_NODELAY: " + clientSocket.getTcpNoDelay());

                // Communicate with the client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = in.readLine();
                System.out.println("Received from client: " + clientMessage);

                out.println("Hello from server with custom socket options!");

                // Close the client connection
                clientSocket.close();
            } catch (SocketTimeoutException e) {
                System.out.println("No client connected within the timeout period.");
            }

            // Close the server socket
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
