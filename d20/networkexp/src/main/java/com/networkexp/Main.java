package com.networkexp;

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
    }

}
