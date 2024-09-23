package Lab45Question;

import java.io.*;
import java.net.*;

public class Ques30Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server is waiting for client connection...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        // Reading the file to be sent
        File file = new File("E://serverfile.txt"); // Specify your file path here
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Sending file contents to the client
        String line;
        while ((line = fileReader.readLine()) != null) {
            out.println(line);  // Send each line to the client
        }

        // Indicate the end of file
        out.println("END_OF_FILE");

        fileReader.close();
        clientSocket.close();
        serverSocket.close();
    }
}

