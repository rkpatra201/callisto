package org.java.examples.threads;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedFileReader {
    private static final int CHUNK_SIZE = 80;
    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        File file = new File("concurrent-read.txt"); // Replace with actual file path
        if (!file.exists()) {
            System.err.println("File does not exist!");
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        long startTime = System.nanoTime(); // Start latency measurement

        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            long fileSize = raf.length();
            long totalChunks = (fileSize + CHUNK_SIZE - 1) / CHUNK_SIZE; // Round up

            for (int i = 0; i < totalChunks; i++) {
                long start = i * CHUNK_SIZE;
                executor.execute(new ChunkReader(file.getAbsolutePath(), start, CHUNK_SIZE));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            while (!executor.isTerminated()) {
                // Wait for all tasks to complete
            }
        }

        long endTime = System.nanoTime(); // End latency measurement
        System.out.println("Total Execution Time (Java Threads): " + (endTime - startTime) / 1_000_000 + " ms");
    }
}

class ChunkReader implements Runnable {
    private final String filePath;
    private final long start;
    private final int chunkSize;

    public ChunkReader(String filePath, long start, int chunkSize) {
        this.filePath = filePath;
        this.start = start;
        this.chunkSize = chunkSize;
    }

    @Override
    public void run() {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            raf.seek(start);
            byte[] buffer = new byte[chunkSize];

            int bytesRead = raf.read(buffer);
            if (bytesRead > 0) {
              //  System.out.println(Thread.currentThread().getName() + " - Read bytes " + start + " to " + (start + bytesRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
