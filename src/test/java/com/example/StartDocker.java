package com.example;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StartDocker {

    public void startDockerService() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("bash -c ./dockerUp.sh");

        String file = "output.txt";
        long timeout = System.currentTimeMillis() + 90000; // 90 seconds timeout
        Thread.sleep(3000); // Initial wait

        boolean isStarted = false;

        while (System.currentTimeMillis() < timeout) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    if (currentLine.contains("registered to the hub and ready to use")) {
                        System.out.println("Docker containers are up and running");
                        isStarted = true;
                        break;
                    }
                }
            }
            if (isStarted) break;
            Thread.sleep(3000); // Wait before checking again
        }

        Assert.assertTrue(isStarted, "Docker did not start successfully!");

        Runtime.getRuntime().exec("bash -c ./scale.sh");
        Thread.sleep(15000); // Wait for scaling to complete
    }
}