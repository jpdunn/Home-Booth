package com.jpdunn;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

import javax.sound.sampled.SourceDataLine;

import com.jpdunn.Helpers.DirectoryWatchingUtility;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner in;
        DirectoryWatchingUtility watcher;
        Path inputDirectory;
        String outputDirectory;
        String inputPath;

        in = new Scanner(System.in);

        System.out.println("Enter the directory to watch:");
        inputPath = in.nextLine();
        inputDirectory = Path.of(inputPath);

        try {

            new DirectoryWatchingUtility(inputDirectory).watch();

            System.out.println("Watching...");
        } catch (IOException e) {
            // TODO: handle exception.
        }

        System.console().readLine();
        in.close();
    }
}
