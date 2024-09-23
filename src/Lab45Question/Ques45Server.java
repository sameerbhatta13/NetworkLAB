package Lab45Question;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Ques45Server {
    public static void main(String[] args) {
        try {
            // Create the GCD service
        	Ques45Interface gcdService = new Ques45Implementation();

            // Create and bind the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("GCDService", gcdService);

            System.out.println("GCD Service is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

