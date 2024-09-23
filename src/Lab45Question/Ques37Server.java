package Lab45Question;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
 
public class Ques37Server {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(5000));  
            serverChannel.configureBlocking(false); 
            System.out.println("Server started, waiting for connections...");

            while (true) {
                // Accept the connection from the client (non-blocking)
                SocketChannel clientChannel = serverChannel.accept();
                if (clientChannel != null) {
                    System.out.println("Connection accepted from: " + clientChannel.getRemoteAddress());

                    // Create a buffer to read data
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    int bytesRead = clientChannel.read(buffer);  
                    if (bytesRead > 0) {
                        buffer.flip();  // Prepare buffer for reading
                        String message = new String(buffer.array(), 0, bytesRead);
                        System.out.println("Message received: " + message);
                    }
                    clientChannel.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

