package Lab45Question;
import java.io.*;
import java.net.Socket;

public class Ques27Client {
    public static void main(String[] args) {
        String host = "localhost"; // Server host
        int port = 12345;          // Server port

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Read and print the response from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

