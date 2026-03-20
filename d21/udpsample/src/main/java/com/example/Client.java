package com.example;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class Client {

    private static final int SERVER_PORT = 5000;
    private static final int PACKET_SIZE = 1024;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] audioFileName = "AudioClip.wav".getBytes();
            DatagramPacket packet = new DatagramPacket(audioFileName, audioFileName.length, InetAddress.getLocalHost(), SERVER_PORT);
            socket.send(packet);
            System.out.println("Sent request to server to listen to: " + new String(audioFileName));

            try {
                File audioFile = new File("C:\\Users\\yviam\\Documents\\GitHub\\java_review\\d21\\udpsample\\src\\main\\java\\com\\example\\AudioClip.wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                System.out.println(audioStream.getFormat());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
