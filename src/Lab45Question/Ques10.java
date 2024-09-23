package Lab45Question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ques10 {
    public static void main(String[] args) {
        // Replace with the URI you want to retrieve data from
        String uri = "https://api.github.com"; // Example URI

        try {
            // Create a URL object from the URI string
            URL url = new URL(uri);
            
            // Open a connection to the URLu
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set the request method
            connection.setRequestMethod("GET");
            
      
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
        
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            
            // Close the BufferedReader
            in.close();
            
            // Print the response
            System.out.println("Response Data:");
            System.out.println(response.toString());

        } catch (IOException e) {
            System.out.println("Error retrieving data from URI: " + e.getMessage());
        }
    }
}

