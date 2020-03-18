package LocatorsHomeWork;

import com.cbt.utillities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
1. Open browser
2. Go to https://google.com
3. Search for one of the strings the list searchStrs given below
4. In the results pages, capture the url right above the first result
5. Click on the first result
6. Verify that url is equal to the value from step 4
7. Navigate back
8. Repeat the same steps for all search items in the list
Note: Do this exercise using a for loop. Here is the list that was mentioned step 3:
List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", “Selenium web browser
automation" );
 */

public class GoogleResultsTitle {



    public static void main(String[] args) throws InterruptedException {



        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation" );
        WebDriver driver = BrowserFactory.getDriver("chrome");

        Map<String, String> listOfUrls = new HashMap<>();


        driver.get("http://google.com");
        Thread.sleep(2000);


        for (int i = 0; i <searchStrs.size() ; i++) {


            WebElement item = driver.findElement(By.name("q"));
            item.clear();

            item.sendKeys(searchStrs.get(i));
            Thread.sleep(2000);
            //using class name
            WebElement searchButton = driver.findElement(By.className("gNO89b")); //works

            //using xpath //tagname[@name = 'btnk'] -> not working
            // WebElement searchButton = driver.findElement(By.tagName("//input [@name='btnK']"));
            //using absolute xpath
            //WebElement searchButton = driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[3]/center/input[1]"));//works
            searchButton.click();

            //String java = "www.java.com";

            Thread.sleep(2000);
            WebElement url = driver.findElement(By.tagName("cite"));
            String urlStr = url.getText();
            System.out.println("urlStr = " + urlStr);

            Thread.sleep(2000);

            WebElement firstResult = driver.findElement(By.tagName("h3"));
            firstResult.click();

            String currentUrl = driver.getCurrentUrl();
            System.out.println("-----------\n");
            if (currentUrl.contains(urlStr)) {
                System.out.println("verified");
            } else {
                System.out.println("not verified");
                System.out.println("currentUrl = " + currentUrl);
                System.out.println("java = " + urlStr);
            }

            listOfUrls.put(urlStr, currentUrl);

            Thread.sleep(2000);

            driver.navigate().back();
            driver.navigate().back();





        }

        System.out.println("listOfUrls = " + listOfUrls);


    }


}
