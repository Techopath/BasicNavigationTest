package LocatorsHomeWork;

import com.cbt.utillities.BrowserFactory;
import com.cbt.utillities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTitle {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://amazon.com");
        Thread.sleep(2000);
        /*
        <input type="text" id="twotabsearchtextbox" value=""
        name="field-keywords" autocomplete="off" placeholder=""
        class="nav-input" dir="auto" tabindex="19">
         */

        String item = "selenium books";
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(item);

        Thread.sleep(2000);

        /*<input type="submit"
        class="nav-input" value="Go" tabindex="20">
         */

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
        searchButton.click();

        String pageTitle = driver.getTitle();


        //String newItem = item.replace(" ", "");
        System.out.println("item = " + item);
        if(pageTitle.contains(item)){
            System.out.println("passed");
            System.out.println("pageTitle = " + pageTitle);

            System.out.println("item = " + item);
        }else {
            System.out.println("failed");
            System.out.println("pageTitle = " + pageTitle);
            System.out.println("item = " + item);
        }

        //driver.close();




    }

}
