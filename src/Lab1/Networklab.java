package Lab1;
import java.net.*;
public class Networklab {
	public static void main(String[] args) {
	try {
	InetAddress me = InetAddress.getLocalHost();
	String dottedQuad = me.getHostAddress();
	String name=me.getHostAddress();
	String nm1 = me.getHostName();
	String nm2 = me.getCanonicalHostName();
//	String url="www.facebook.com";
	InetAddress me1=InetAddress.getByName("www.quora.com");
	System.out.println("My address is " + dottedQuad);
	System.out.println("My address is 1 " + name);
	System.out.println("My address is 2 " + nm1);
	System.out.println("My address is  3 " + nm2);
	System.out.println("hello");
	System.out.println(me1);
	} catch (UnknownHostException ex) {
	System.out.println("I'm sorry. I don't know my own address.");
	}
	}


}
