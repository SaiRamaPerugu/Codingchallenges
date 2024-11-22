package com.ram.challenges.netcat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPPortListener {

    public static void main(String[] args) {
        int port = 9876;
        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            System.out.println("UDP Server listening on port " + port);
            byte[] data = new byte[20];

            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
                serverSocket.receive(datagramPacket);
                String message = new String(datagramPacket.getData());
                System.out.println("Received message: " + message);

                InetAddress clientAddress = datagramPacket.getAddress();
                int clientPort = datagramPacket.getPort();

                // Send a response back to the client
                String response = "Hello from server!";
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}