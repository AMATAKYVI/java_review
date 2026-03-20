package com.networkexp;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // try (ServerSocket serverSocket = new ServerSocket(8080)) {
        //     System.out.println("Server is listening on port 8080");
        //     try (Socket socket = serverSocket.accept()) {
        //         System.out.println("Client connected: " + socket.getInetAddress());
        //         BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //         PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        //         while (true) {
        //             String echo = reader.readLine();
        //             if (echo == null || echo.equalsIgnoreCase("exit")) {
        //                 System.out.println("Client disconnected: " + socket.getInetAddress());
        //                 break;
        //             }
        //             System.out.println("Received: " + echo);
        //             output.println(echo);
        //         }
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        Consumer<ByteBuffer> consumer = buffer -> {
            while (buffer.hasRemaining()) {
                System.out.print(buffer.get() + " ");
            }
            System.out.println();
        };

        ByteBuffer buffer = ByteBuffer.allocate(200);
        doOperation("Initial state", buffer, consumer);
        doOperation("Flip buffer", buffer.flip(), consumer);
    }

    private static void doOperation(String op, ByteBuffer buffer, Consumer<ByteBuffer> consumer) {
        System.out.printf("%-30s", op);
        consumer.accept(buffer);
        System.out.println("Buffer position: " + buffer.position() + ", limit: " + buffer.limit());
    }
}
