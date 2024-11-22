package com.ram.project;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ReadFromFile {

    public static void main(String[] args) throws InterruptedException {
        String fileName  = "C:\\Users\\RP140251\\OneDrive - BGC Partners, O365 Tenant\\OneDrive - BGCG, O365 Tenant\\Profile\\Desktop\\test.txt";
        HashSet<Integer> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        int lineNumber = 0;
        Runnable runnable1 = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    list.add("Thread 1 wrote: " + i + "\n");
                }
                Thread.sleep(0);
            } catch ( InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable2 = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    list.add("Thread 2 wrote: " + i + "\n");
                }
                Thread.sleep(0);
            } catch ( InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread writerThread1 = new Thread(runnable1);
        writerThread1.start();
        Thread writerThread2 = new Thread(runnable2);
        writerThread2.start();

        writerThread1.join();
        writerThread2.join();
        list.stream().forEach(System.out::print);
        /*Thread readerThread = new Thread();
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                        String line = null;
                        lineNumber = 0;
                        while ((line = bufferedReader.readLine()) != null) {
                            lineNumber++;
                            if(!set.contains(lineNumber)) {
                                System.out.println(line + " " + LocalDateTime.now());
                            }
                            set.add(lineNumber);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
       */


    }
}
