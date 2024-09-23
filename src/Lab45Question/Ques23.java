package Lab45Question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ques23 {
    public static void main(String[] args) {
        try {
            // Specify the URL to connect to
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/1"); // Replace with your URL
            
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Configure the connection properties
            connection.setRequestMethod("GET"); // Set the HTTP method (GET, POST, etc.)
            connection.setConnectTimeout(5000); // Set connection timeout (5 seconds)
            connection.setReadTimeout(5000);    // Set read timeout (5 seconds)
            connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // Set request header
            
            // Connect and check the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            // Read the response if the connection was successful
            if (responseCode == HttpURLConnection.HTTP_OK) { // 200 OK
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                // Print the response
                System.out.println("Response:\n" + response.toString());
            } else {
                System.out.println("Failed to fetch the URL content.");
            }

            // Disconnect the connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

