package Lab45Question;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Ques26Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            String userInput;
            while (true) {
                System.out.print("Enter message (or 'exit' to quit): ");
                userInput = scanner.nextLine();
                if ("exit".equalsIgnoreCase(userInput)) break;
                out.println(userInput);
                System.out.println("Echo from server: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

