package com.cbt.Covid2019;

import com.cbt.utillities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitedStates {

    public static void main(String[] args) throws InterruptedException {
            virginia();
    }
    private static void virginia() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");

//        driver.get("http://google.com");
//        Thread.sleep(2000);
        driver.get("https://www.ecdc.europa.eu/en/cases-2019-ncov-eueea");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        String cMap = "casesMap";
        int count =1;
        for (int i = 0; i < count; i++) {

        }
        Map<String, String> casesMap= new HashMap<>();
        WebElement italy = driver.findElement(By.xpath("//*[@id=\"mm-0\"]/div[3]/div/div[1]/main/section[2]/div/div/div/div[2]/div/section/div/div[3]/div[2]/div/table/tbody/tr[1]/td[1]"));
        String italyText = italy.getText();
        System.out.println(italy.getText());
        WebElement italyNum = driver.findElement(By.xpath("//*[@id=\"mm-0\"]/div[3]/div/div[1]/main/section[2]/div/div/div/div[2]/div/section/div/div[3]/div[2]/div/table/tbody/tr[1]/td[2]"));
        String numberIt = italyNum.getText();

        WebElement spain = driver.findElement(By.xpath("//*[@id=\"mm-0\"]/div[3]/div/div[1]/main/section[2]/div/div/div/div[2]/div/section/div/div[3]/div[2]/div/table/tbody/tr[2]/td[1]"));
        String spainText = spain.getText();
        WebElement spainNum = driver.findElement(By.xpath("//*[@id=\"mm-0\"]/div[3]/div/div[1]/main/section[2]/div/div/div/div[2]/div/section/div/div[3]/div[2]/div/table/tbody/tr[2]/td[2]"));
        String numberSp = spainNum.getText();
        casesMap.put(italyText, numberIt);
        casesMap.put(spainText,numberSp);

        System.out.println(casesMap.toString());






    }

}
