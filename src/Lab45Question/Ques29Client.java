package Lab45Question;
import java.io.*;
import java.net.*;

public class Ques29Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6789);

        // Send number to server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        int number = 5; // Number to calculate factorial for]
        
        out.println(number);

        // Get factorial result from server
        String result = in.readLine();
        System.out.println("Factorial of " + number + " is: " + result);

        socket.close();
    }
}

