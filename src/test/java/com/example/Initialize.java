package com.example;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class Initialize {

    @BeforeSuite
    public void startDocker() throws IOException, InterruptedException {
        File file = new File("output.txt");
        if (file.delete()) {
            System.out.println("Output file deleted successfully");
        }
        StartDocker startDocker = new StartDocker();
        startDocker.startDockerService();
    }

    @AfterSuite
    public void stopDocker() throws IOException, InterruptedException {
        StopDocker stopDocker = new StopDocker();
        stopDocker.stopDockerService();
    }

}