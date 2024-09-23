package Lab45Question;

import java.net.HttpURLConnection;
import java.net.URL;

public class Ques22 {
    public static void main(String[] args) {
        try {
            // Specify the URL
            URL url = new URL("http://www.facebook.com"); // Replace with desired URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Send a GET request
            connection.setRequestMethod("GET");
            connection.connect();
            
            // Print the entire HTTP header
            System.out.println("HTTP Headers:");
            for (int i = 0; ; i++) {
                String headerName = connection.getHeaderFieldKey(i);
                String headerValue = connection.getHeaderField(i);
                if (headerName == null && headerValue == null) {
                    break; // No more headers
                }
                if (headerName == null) {
                    System.out.println(headerValue); // First header line
                } else {
                    System.out.println(headerName + ": " + headerValue);
                }
            }

            // Disconnect the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
