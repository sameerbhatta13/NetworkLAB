package Lab45Question;

import java.io.*;
import java.net.*;

public class Ques28Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6789)) {
            System.out.println("Server is listening on port 6789");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Receive and respond to message
            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);

            // Sending response to client
            out.println("Server received: " + clientMessage);

            // Close connections
            clientSocket.close();
            System.out.println("Client disconnected");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

