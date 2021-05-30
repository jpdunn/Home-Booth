package com.jpdunn.Helpers;

import io.methvin.watcher.DirectoryWatcher;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class DirectoryWatchingUtility {

    private final Path directoryToWatch;
    private final DirectoryWatcher watcher;

    public DirectoryWatchingUtility(Path directoryToWatch) throws IOException {
        this.directoryToWatch = directoryToWatch;

        this.watcher = DirectoryWatcher.builder().path(this.directoryToWatch).listener(event -> {
            switch (event.eventType()) {
                case CREATE:
                    System.out.println("File Created");
                    System.out.println(event.path());
                    break;
                case MODIFY:
                    System.out.println("File Modified");
                    System.out.println(event.path());
                    break;
                case DELETE:
                    System.out.println("File Deleted");
                    System.out.println(event.path());
                    break;
            }
        }).build();
    }

    public void stopWatching() throws IOException {
        watcher.close();
    }

    public CompletableFuture<Void> watch() {
        // you can also use watcher.watch() to block the current thread
        return watcher.watchAsync();
    }
}