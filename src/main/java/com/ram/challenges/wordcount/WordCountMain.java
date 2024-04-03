package com.ram.challenges.wordcount;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class WordCountMain {


    public static void main(String[] args) throws Exception {
        //test
        if(args.length == 0) {
            System.out.println("Invalid number of arguments");
            System.exit(1);
        }

        int numberOfArgs = args.length;

        String command = args[0];
        String option = args[1];

        if(validCommandOptions(command, option)) {
            if(command.equals("wc")) {
                wordCountProcessor(option, checkValidFile(args[numberOfArgs-1]));
            }
        }
    }

    public static Path checkValidFile(String filePath) {
        Path path;
        try {
            path = Paths.get(filePath);
        } catch(Exception ex) {
            throw new RuntimeException("value is not a file." + filePath);
        }
        return path;
    }

    public static boolean validCommandOptions(String command, String option) {
        HashMap<String, List<String>> commands = new HashMap<>();
        commands.put("wc", new ArrayList<>(Arrays.asList("-l", "-w", "-c")));

        if(!commands.containsKey(command)) {
            System.out.println("Invalid command");
            return false;
        }
        List<String> availableOptions = commands.get(command);
        if(!availableOptions.contains(option)) {
            System.out.println("Invalid option for command " + command);
            return false;
        }
        return true;
    }

    public static void wordCountProcessor(String option, Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
        AtomicLong wordCount = new AtomicLong();
        AtomicLong byteCount = new AtomicLong();
        switch(option) {
            case "-l":
                System.out.println("Line count: " + lines.size());
                break;
            case "-w":
                lines.forEach(line -> wordCount.addAndGet(Arrays.stream(line.split(" ")).count()));
                System.out.println("Word count: " + wordCount.get());
                break;
            case "-c":
                lines.forEach(line -> byteCount.addAndGet(line.getBytes(StandardCharsets.UTF_8).length));
                System.out.println("ByteCount: " + byteCount.get());
                break;
            default:
                break;
        }

        System.out.println(lines);
    }
}