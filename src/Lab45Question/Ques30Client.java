package Lab45Question;

import java.io.*;
import java.net.*;

public class Ques30Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6789);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Receiving the file contents from the server
        String line;
        System.out.println("Receiving file from server...");
        while (!(line = in.readLine()).equals("END_OF_FILE")) {
            System.out.println(line);  // Print the received content
        }

        socket.close();
    }
}

