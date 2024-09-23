package Lab45Question;

import java.io.*;
import java.net.*;

public class Ques28Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6789)) {
            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            out.println("Hello from the client!");

            // Read server's response
            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
