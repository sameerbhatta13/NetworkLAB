package Lab45Question;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class Ques16 extends ProxySelector {
    private final ProxySelector defaultSelector = ProxySelector.getDefault();
    private final Map<URI, Proxy> successfulConnections = new HashMap<>();

    @Override
    public List<Proxy> select(URI uri) {
        return successfulConnections.containsKey(uri) 
               ? Collections.singletonList(successfulConnections.get(uri))
               : defaultSelector.select(uri);
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        System.out.println("Connection failed: " + uri);
        defaultSelector.connectFailed(uri, sa, ioe);
    }

    public void rememberSuccessfulConnection(URI uri, Proxy proxy) {
        successfulConnections.put(uri, proxy);
        System.out.println("Remembered proxy for " + uri);
    }

    public static void main(String[] args) throws Exception {
        ProxySelector.setDefault(new Ques16());
        URI testURI = new URI("http://www.google.com");
        List<Proxy> proxies = ProxySelector.getDefault().select(testURI);
        System.out.println("Proxies: " + proxies);
    }
}
