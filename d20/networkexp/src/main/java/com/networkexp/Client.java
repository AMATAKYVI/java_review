package com.networkexp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        try (Socket socket = new Socket("localhost", 8080)) {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            String requestString;
            String responseString;

            do {
                System.out.println("Enter a message to send to the server (type 'exit' to quit):");
                requestString = scanner.nextLine();
                output.println(requestString);
                responseString = reader.readLine();
                System.out.println("Received from server: " + responseString);
            } while (!requestString.equalsIgnoreCase("exit"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Client is closing.");
        }
    }
}
