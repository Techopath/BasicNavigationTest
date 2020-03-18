package com.cbt.utillities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

//create a public static method called getDriver which takes a string argument

    public static WebDriver getDriver(String browserName){
        WebDriver driver = null;

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if (browserName.equalsIgnoreCase("safari")) {
            return null;
        }

//            switch (browserName){
//                case "chrome":
//                    driver = new ChromeDriver();
//                case "firefox":
//                    driver = new FirefoxDriver();
//                case "edge":
//                    driver = new EdgeDriver();
//                case "safari":
//                    return null;
//            }

        return driver;

    }

}
