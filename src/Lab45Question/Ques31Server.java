package Lab45Question;
import java.io.*;
import java.net.*;

public class Ques31Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server is waiting for clients...");

        while (true) {
     
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle each client in a new thread
            new Thread(new PrimeHandler(clientSocket)).start();
        }
    }
}

class PrimeHandler implements Runnable {
    private Socket clientSocket;

    public PrimeHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read number from client
            String input = in.readLine();
            int number = Integer.parseInt(input);

            // Check if the number is prime
            boolean isPrime = checkPrime(number);
            String result = number + (isPrime ? " is a prime number." : " is not a prime number.");

            // Send result back to client
            out.println(result);

            // Close connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to check if a number is prime
    private boolean checkPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

