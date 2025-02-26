package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestCase2 {

    @Test
    public void testcase2() throws MalformedURLException {
        // TODO Auto-generated method stub
        ChromeOptions options = new ChromeOptions();
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, options);

        //Write your code here to run on second container
        driver.get("http://github.com");
        System.out.println(driver.getTitle());
        System.out.println("Test case ran in the 2nd Docker container.....");
    }

}