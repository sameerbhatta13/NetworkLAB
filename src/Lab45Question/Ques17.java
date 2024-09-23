package Lab45Question;

import java.net.*;

public class Ques17 implements CookiePolicy {

    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        // Get the host from the URI
        String host = uri.getHost().toLowerCase();

        // Block cookies from .gov domains
        if (host.endsWith(".gov")) {
            System.out.println("Blocking cookies from: " + host);
            return false;
        }

        // Allow cookies from other domains
        System.out.println("Allowing cookies from: " + host);
        return true;
    }

    public static void main(String[] args) throws Exception {
        // Set the custom cookie policy
        CookieManager cookieManager = new CookieManager(null, new Ques17());
        CookieHandler.setDefault(cookieManager);

        // Test the policy with different URIs
        URI govUri = new URI("http://java.gov");
        URI comUri = new URI("http://javascript.com");

        // Creating test cookies
        HttpCookie govCookie = new HttpCookie("session", "123");
        HttpCookie comCookie = new HttpCookie("session", "456");
        
 

        // Test the cookie policy by trying to store cookies
//        System.out.println("Cookie for .gov accepted: " +cookieManager.getCookieStore().add(govUri, govCookie));
//        System.out.println("Cookie for .com accepted: " + cookieManager.getCookieStore().add(comUri, comCookie));
    }
}

//.add(govUri, govCookie)


