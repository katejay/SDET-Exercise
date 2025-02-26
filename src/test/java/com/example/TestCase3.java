package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestCase3 {

    @Test
    public void testcase3() throws MalformedURLException {
        // TODO Auto-generated method stub
        ChromeOptions options = new ChromeOptions();
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, options);

        //Write your code here to run on third container
        driver.get("http://gmail.com");
        System.out.println(driver.getTitle());
        System.out.println("Test case ran in the 3rd Docker container.....");
    }

}