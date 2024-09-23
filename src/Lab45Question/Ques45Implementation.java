package Lab45Question;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Ques45Implementation extends UnicastRemoteObject implements Ques45Interface {

    public Ques45Implementation() throws RemoteException {
        super();
    }

    @Override
    public int calculateGCD(int a, int b) throws RemoteException {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

