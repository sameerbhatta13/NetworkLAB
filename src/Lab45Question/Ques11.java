package Lab45Question;


import java.net.URL;
public class Ques11 {
	 public static void main(String args[]) throws Exception {

		  //  URL u = new URL("http://www.java2s.com:80/index.html?id=5#top");
		    URL u = new URL("https://jcs.mobile-utopia.com/servlet/Source?type=s&q=urlconnection");
		    System.out.println("The URL is " + u);
		    System.out.println("The scheme/Protocal is " + u.getProtocol());
		    System.out.println("The user info is " + u.getUserInfo());

		    String host = u.getHost();
		    if (host != null) {
		      int atSign = host.indexOf('@');
		      if (atSign != -1)
		        host = host.substring(atSign + 1);
		      System.out.println("The host is " + host);
		    } else {
		      System.out.println("The host is null.");
		    }

		    System.out.println("The port is " + u.getPort());
		    System.out.println("The path is " + u.getPath());
		    System.out.println("The ref is " + u.getRef());
		    System.out.println("The query string is " + u.getQuery());
	 }
}
