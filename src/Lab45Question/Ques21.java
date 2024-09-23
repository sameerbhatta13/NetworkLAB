package Lab45Question;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.regex.*;

public class Ques21 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com"); // Replace with desired URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Get charset from Content-Type header
            String contentType = conn.getHeaderField("Content-Type");
            String charset = "UTF-8"; // Default charset
            Matcher m = Pattern.compile("charset=([\\w-]+)").matcher(contentType);
            if (m.find()) charset = m.group(1);

            // Read content with correct charset
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName(charset)));
            BufferedWriter writer = new BufferedWriter(new FileWriter("downloaded_page.html"));
            String line;
            while ((line = reader.readLine()) != null) writer.write(line + "\n");

            reader.close(); writer.close();
            System.out.println("Page downloaded with charset: " + charset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

