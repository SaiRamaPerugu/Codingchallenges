package com.ram.challenges.netcat;

import java.io.IOException;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public class PortListener {
    public static void main(String[] args) throws IOException {
        int portNumber = 8080;
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();

                if (networkInterface.isUp()) {
                    System.out.println("Interface: " + networkInterface.getName());
                    System.out.println("Display Name: " + networkInterface.getDisplayName());
                    System.out.println("Hardware Address: " + networkInterface.getHardwareAddress());
                    System.out.println("------------------------------------");
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try(ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server listening on port: " + portNumber);
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected : " + clientSocket.getInetAddress().getHostAddress());
                new ClientHandler(clientSocket).start();
            }
        }


    }
}
