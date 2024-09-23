package Lab45Question;

import java.net.HttpURLConnection;
import java.net.URL;

public class Ques19 {
    public static void main(String[] args) {
        try {
            // Specify the URL
            URL url = new URL("http://www.facebook.com"); // Replace with desired URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Send a GET request
            connection.setRequestMethod("GET");
            connection.connect();

            // Retrieve specific headers
            String contentType = connection.getHeaderField("Content-Type");
            String contentLength = connection.getHeaderField("Content-Length");
            String server = connection.getHeaderField("Server");

            // Print the retrieved headers
            System.out.println("Content-Type: " + contentType);
            System.out.println("Content-Length: " + contentLength);
            System.out.println("Server: " + server);

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

