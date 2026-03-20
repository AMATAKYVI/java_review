package com.example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {

    private static final int PORT = 5000;
    private static final int PACKET_SIZE = 1024;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        try (DatagramSocket socket = new DatagramSocket(PORT)) {

            byte[] buffer = new byte[PACKET_SIZE];

            System.out.println("Waiting for incoming UDP packets on port " + PORT + "...");

            DatagramPacket clientPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(clientPacket);
            String audioFileName = new String(buffer, 0, clientPacket.getLength());
            System.out.println("Client requested to listen to: " + audioFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
