package Lab45Question;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Ques45Interface extends Remote {
    int calculateGCD(int a, int b) throws RemoteException;
}
