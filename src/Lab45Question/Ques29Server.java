package Lab45Question;

import java.io.*;
import java.net.*;

public class Ques29Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server is waiting for client...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        // Read input from client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Read number from client
        int number = Integer.parseInt(in.readLine());

        // Calculate factorial
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }

        // Send factorial result to client
        out.println(result);

        clientSocket.close();
        serverSocket.close();
    }
}
