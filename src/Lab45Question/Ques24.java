package Lab45Question;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class Ques24 {
	public static void main(String[] args) {
        URL wiki = null;
        BufferedReader in = null;
        try {
           wiki = new URL("https://en.wikipedia.org/wiki/Computer_science");
        } catch(MalformedURLException e) {
            System.out.println("Cannot find webpage " + wiki);
            System.exit(-1);
        }
        try {
            URLConnection  aConnection = wiki.openConnection();
            in = new BufferedReader(
                        new InputStreamReader(aConnection.getInputStream()));
        }
        catch (IOException e) {
            System.out.println("Cannot connect to webpage " + wiki);
            System.exit(-1);
        }
        try {
            // Now read the webpage file
            String lineOfWebPage;
            while ((lineOfWebPage = in.readLine()) != null)
                System.out.println(lineOfWebPage);
            in.close(); // Close the connection to the net
        } catch(IOException e) {
            System.out.println("Cannot read from webpage " + wiki);
        }
    }
}