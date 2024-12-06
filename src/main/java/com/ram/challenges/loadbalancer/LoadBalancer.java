package com.ram.challenges.loadbalancer;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class LoadBalancer {

    int port;

    public LoadBalancer(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                Thread.sleep(1000); // Sleep for 1 second
                clientSocket.setSoLinger(true, 0);
                clientSocket.close();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
