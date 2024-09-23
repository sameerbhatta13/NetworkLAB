package Lab45Question;

import java.io.*;
import java.net.*;

public class Ques31Client {
    public static void main(String[] args) throws IOException {
        // Connect to the server
        Socket socket = new Socket("localhost", 6789);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        // Input number from user
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a number to check if it's prime: ");
        String number = userInput.readLine();

        // Send number to server
        out.println(number);

        // Receive result from server
        String result = in.readLine();
        System.out.println("Server response: " + result);

        // Close connection
        socket.close();
    }
}
