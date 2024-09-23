package Lab45Question;

import java.net.*;
import java.util.List;
import java.util.Map;

public class Ques18 {
    public static void main(String[] args) throws Exception {
        // Set up cookie manager
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        // Send a GET request
        URL url = new URL("http://www.example.com"); // Replace with desired URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // Retrieve and print cookies
        List<String> cookies = connection.getHeaderFields().get("Set-Cookie");
        if (cookies != null) {
            System.out.println("Cookies received:");
            for (String cookie : cookies) {
                System.out.println(cookie);
            }
        } else {
            System.out.println("No cookies received.");
        }

        connection.disconnect(); // Close the connection
    }
}
