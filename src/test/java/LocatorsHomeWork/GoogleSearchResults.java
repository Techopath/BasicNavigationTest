package LocatorsHomeWork;

import com.cbt.utillities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

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
public class GoogleSearchResults {

    public static void main(String[] args) throws InterruptedException {
       //1
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //2
        driver.get("http://google.com");

        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation" );
        //List<String> searchStrs = Arrays.asList("Java");

       //3
        Thread.sleep(2000);
        for (String searchStr:searchStrs) {
            Thread.sleep(2000);

            WebElement searchInput = driver.findElement(By.name("q"));
            searchInput.clear();
            searchInput.sendKeys(searchStr+ Keys.ENTER);

            //WebElement url = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div.r > a > div > cite"));
            //iUh30 tjvcx -> using css we put dot instead of spaces.

            //4
            Thread.sleep(2000);

            WebElement url = driver.findElement(By.cssSelector(".iUh30.tjvcx"));
            System.out.println("url: "+url.getText());
            String expectedUrl = url.getText();

           //5
            Thread.sleep(2000);

            //WebElement link = driver.findElement(By.tagName("h3"));
            WebElement link = driver.findElement(By.cssSelector("div.r>a>h3"));
            link.click();
           //6
            if (expectedUrl.equals(driver.getCurrentUrl())){
                System.out.println("pass");
            }else{
                System.out.println("fail");
                System.out.println("Expected: "+expectedUrl);
                System.out.println("actual : "+driver.getCurrentUrl());
            }
            Thread.sleep(2000);

            driver.navigate().back();




        }

        driver.quit();





    }

}
