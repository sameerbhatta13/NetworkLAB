package Lab45Question;
 
import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;
 
import java.net.URLEncoder;
public class Ques15 {
	  public static void main(String[] args) { 
	        String url1=" https%3A%2F%2Ftechdevguide.withgoogle.com%2F"; 

	        String string_after_decoding = URLdecoder(url1); System.out.println("Decoded URL: "+string_after_decoding); 
	        
	    }
	    public static String URLdecoder(String url) { 

	        try { 

	            String initial=""; 

	            String final_string =url; 
	            
	            while(!initial.equals(final_string)) { 
	                
	                initial=final_string; 

	                final_string=URLDecoder.decode( final_string, "UTF-8" ); 
	                
	            } return final_string; 
	            
	        } catch (UnsupportedEncodingException e) { 

	                return "Issue while decoding" +e.getMessage(); 
	                
	            } 
	        
	    }
}