package com.cbt.tests;

import com.cbt.utillities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class NavigationTest {
    public static void main(String[] args) throws InterruptedException {

        String [] browsers = {"chrome", "firefox", "edge", "safari"};

        for (int i = 0; i < browsers.length; i++) {
            WebDriver driver = BrowserFactory.getDriver(browsers[i]);
            String urlGoogle = "https://google.com";
            String urlEtsy = "https://etsy.com";
            //-----
            driver.get(urlGoogle);
            Thread.sleep(2000);
            String titleG = driver.getTitle();


            //-----
            Thread.sleep(2000);
            driver.navigate().to(urlEtsy);
            String titleE = driver.getTitle();
            //---
            Thread.sleep(2000);
            driver.navigate().back();
            //----
            if("exp".equals(titleG)){
                System.out.println("pass");
            }else{
                System.out.println("fail");
                System.out.println("title: "+titleG);
            }
            Thread.sleep(2000);
            driver.navigate().forward();
            if("exp".equals(titleE)){
                System.out.println("pass");
            }else{
                System.out.println("fail");
                System.out.println("title: "+titleE);
            }

            driver.close();


        }


    }
}
