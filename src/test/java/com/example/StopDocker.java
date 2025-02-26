package com.example;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StopDocker {

    public void stopDockerService() throws IOException, InterruptedException {
        boolean isStopped = false;
        Runtime.getRuntime().exec("bash -c ./dockerDown.sh");
        Thread.sleep(5000); // Initial wait after shutdown command

        long endTime = System.currentTimeMillis() + 45000; // 45 seconds timeout
        while (System.currentTimeMillis() < endTime) {
            try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("selenium-hub exited")) {
                        isStopped = true;
                        break;
                    }
                }
            }
            if (isStopped) break;
            Thread.sleep(3000); // Wait before rechecking
        }

        Assert.assertTrue(isStopped, "Docker did not stop successfully!");
    }
}