package Lab45Question;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Ques20 {
    public static void main(String[] args) {
        try {
            // Specify the URL
            URL url = new URL("http://www.facebook.com"); // Replace with desired URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Send a GET request
            connection.setRequestMethod("GET");
            connection.connect();

            // Prompt user for header name
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the header name to retrieve: ");
            String headerName = scanner.nextLine();

            // Retrieve and print the specified header
            String headerValue = connection.getHeaderField(headerName);
            if (headerValue != null) {
                System.out.println(headerName + ": " + headerValue);
            } else {
                System.out.println("Header not found: " + headerName);
            }

            // Close the connection
            connection.disconnect();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

