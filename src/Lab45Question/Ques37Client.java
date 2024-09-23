package Lab45Question;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Ques37Client {

    public static void main(String[] args) {
        try {
            // Create a non-blocking socket channel
            SocketChannel clientChannel = SocketChannel.open();
            clientChannel.configureBlocking(false); 

            // Connect to the server on port 5000
            clientChannel.connect(new InetSocketAddress("localhost", 5000));

            // Wait until the connection is established (non-blocking)
            while (!clientChannel.finishConnect()) {
                System.out.println("Connecting to server...");
            }

            // Prepare a message to send
            String message = "Hello, NIO Server!";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());

            // Send the message
            clientChannel.write(buffer);
            System.out.println("Message sent to server: " + message);
            
            clientChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

