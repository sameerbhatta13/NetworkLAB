package Lab45Question;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class Ques34 {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new FileHandler());
        server.setExecutor(null); // Default executor
        server.start();
        System.out.println("Server running on http://localhost:8080");
    }
}

class FileHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        File file = new File("www" + exchange.getRequestURI().getPath());
        
        if (file.exists() && !file.isDirectory()) {
            exchange.getResponseHeaders().set("Content-Type", Files.probeContentType(file.toPath()));
            exchange.sendResponseHeaders(200, file.length());
            Files.copy(file.toPath(), exchange.getResponseBody());
        } else {
            String response = "404 (File Not Found)";
            exchange.sendResponseHeaders(404, response.length());
            exchange.getResponseBody().write(response.getBytes());
        }
        exchange.getResponseBody().close();
    }
}

