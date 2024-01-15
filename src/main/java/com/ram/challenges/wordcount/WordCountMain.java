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
        String command = args[0];
        String option = args[1];
        Path path = null;

        if(args.length != 3) {
            System.out.println("Invalid number of arguments");
        }

        try {
            path = Paths.get(args[2]);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        if(validCommandOptions(command, option)) {
            if(command.equals("wc")) {
                wordCountProcessor(option, path);
            }
        }
    }

    public static boolean validCommandOptions(String command, String option) {
        HashMap<String, List<String>> commands = new HashMap<>();
        commands.put("wc", new ArrayList<>(Arrays.asList("-l", "-c")));

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
        if(option.equals("-l")) {
            System.out.println("Line count: " + lines.size());
        } else if(option.equals("-w")) {
            lines.forEach(line -> wordCount.addAndGet(Arrays.stream(line.split(" ")).count()));
            System.out.println("Wordcount: " + wordCount.get());
        } else if(option.equals("-c")) {
            lines.forEach(line -> byteCount.addAndGet(line.getBytes(StandardCharsets.UTF_8).length));
            System.out.println("ByteCount: " + byteCount.get());
        }

        System.out.println(lines);
    }
}