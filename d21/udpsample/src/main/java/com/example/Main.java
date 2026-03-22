package com.example;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

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
            sendDataToClient(audioFileName, socket, clientPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void sendDataToClient(String file, DatagramSocket socket, DatagramPacket clientPacket) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(PACKET_SIZE);

        System.out.println(file);
        try (FileChannel fileChannel = FileChannel.open(new File("C:\\\\Users\\\\yviam\\\\Documents\\\\GitHub\\\\java_review\\\\d21\\\\udpsample\\\\src\\\\main\\\\java\\\\com\\\\example\\\\" + file).toPath(), StandardOpenOption.READ)) {
            InetAddress clientAddress = clientPacket.getAddress();
            int clientPort = clientPacket.getPort();

            while (true) {
                byteBuffer.clear();
                int bytesRead = fileChannel.read(byteBuffer);
                if (bytesRead == -1) {
                    break; // End of file reached
                }
                byteBuffer.flip();
                byte[] data = new byte[bytesRead];
                byteBuffer.get(data);

                DatagramPacket packet = new DatagramPacket(data, data.length, clientAddress, clientPort);
                socket.send(packet);
            }

            try {
                TimeUnit.MILLISECONDS.sleep(22);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
