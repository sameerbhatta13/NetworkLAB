package Lab45Question;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Ques45Client {
    public static void main(String[] args) {
        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup the GCD service
            Ques45Interface gcdService = (Ques45Interface) registry.lookup("GCDService");

            // Calculate GCD of two numbers
            int a = 48;
            int b = 18;
            int gcd = gcdService.calculateGCD(a, b);

            System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
