package Lab45Question;

import java.net.*; 
import java.util.*;
import java.lang.*; 
public class Ques4 {
	 public static int getVersion(InetAddress ia) 
	 { 
	 byte[] address = ia.getAddress(); 
	 if(address.length == 4) 
	 return 4; 
	 else if(address.length == 16)
	  return 6;
	  else 
	 return -1;
	  } 
	 public static void main(String[] args) throws UnknownHostException
	  {
//	 InetAddress address = InetAddress.getByName("2001:0db8:85a3:0000:0000:8a2e:0370:7334"); 
	 InetAddress address = InetAddress.getByName("192.168.20.10");
	 byte[] bytes = address.getAddress();
	 for (byte b : bytes) {
	   System.out.println(b & 0xFF);
	         }

//	 address = InetAddress.getByName("192.168.2.1"); 
	 int x = getVersion(address);
	      switch (x) {
	          case 4:
	              System.out.println("IPv4 Address.");
	              break;
	          case 6:
	              System.out.println("IPv6 Address."); 
	              break;
	          default:
	              System.out.println("Invalid Address.");
	              break;
	      }
	 } 
}
