package com.example;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

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
                playStreamedAudio(socket);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void playStreamedAudio(DatagramSocket socket) throws SocketException, LineUnavailableException {
        // This method would contain logic to receive audio data packets and play them in real-time.
        // For simplicity, this is left as a placeholder.

        socket.setSoTimeout(20000);
        AudioFormat audioFormat = new AudioFormat(44100, 16, 2, true, false);
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);
        audioLine.open();
        audioLine.start();

        byte[] buffer = new byte[PACKET_SIZE];

        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                audioLine.write(buffer, 0, packet.getLength());
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        audioLine.close();
    }

}
