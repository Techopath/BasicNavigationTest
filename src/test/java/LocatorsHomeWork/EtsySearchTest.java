package LocatorsHomeWork;

import com.cbt.utillities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

/*
beaucrabill.zendesk.com
notes:
Suppliers first, products second
sell needs, not wants. not new mac but sd cards
ASIN: AMAZON STANDARD INVENTORY NUMBER.


 */

public class EtsySearchTest {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://google.com");
        Thread.sleep(2000);

        driver.get("http://etsy.com");
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys(" wooden spoon");

        WebElement searchButton = driver.findElement(By.className("wt-input-btn-group__btn"));

        searchButton.click();
        WebElement itemsFound = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div/div[3]/div[2]/div[1]/div[1]/div/span[3]"));

        String results = itemsFound.getText();

        //System.out.println("results = " + results);
        String num = "";

        //System.out.println(results.charAt(2));

        for (int i = 0; i < results.length(); i++) {
            if (results.charAt(i) =='0' || results.charAt(i)=='1' || results.charAt(i)=='2' || results.charAt(i)=='3' || results.charAt(i)=='5'
                    || results.charAt(i)=='6'|| results.charAt(i)=='7' || results.charAt(i)=='8' || results.charAt(i)=='9'){
                num = num+results.charAt(i);

            }
        }

        int n = Integer.parseInt(num);
        System.out.println("n = " + n);

        //System.out.println("num = " + num);

        Thread.sleep(2000);

        WebElement all = driver.findElement(By.linkText("All categories"));

        all.click();

        WebElement itemsInAll = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div/div[3]/div[2]/div[1]/div[1]/div/span[3]"));


        String allResults = itemsInAll.getText();
        System.out.println("allResults = " + allResults);

        String numsAll = "";

        for (int i = 0; i < allResults.length(); i++) {
            if (allResults.charAt(i) =='0' || allResults.charAt(i)=='1' || allResults.charAt(i)=='2' || allResults.charAt(i)=='3' || allResults.charAt(i)=='5'
                    || allResults.charAt(i)=='6'|| allResults.charAt(i)=='7' || allResults.charAt(i)=='8' || allResults.charAt(i)=='9'){
                numsAll = numsAll+allResults.charAt(i);

            }
        }

        int numsInAll = Integer.parseInt(numsAll);
        System.out.println("numsInAll = " + numsInAll);

        if (numsInAll > n){
            System.out.println("passed");
            System.out.println("All categories link has more results: "+numsInAll);

        }else {
            System.out.println("failed");
            System.out.println("They are equal");
            System.out.println("numsInAll = " + numsInAll);
            System.out.println("n = " + n);
        }

        Thread.sleep(2000);

        driver.navigate().back();

        //wooden spoon is still displaying in the box

        WebElement itemInSearchBox = driver.findElement(By.id("global-enhancements-search-query"));

        String ws = itemInSearchBox.getAttribute("value");

        System.out.println("ws = " + ws);

        if(ws.equals("wooden spoon")){
            System.out.println("test passed, item still written there");
        }else {
            System.out.println("test failed, item is not there");
        }

        driver.navigate().back();

        String empty = driver.findElement(By.id("global-enhancements-search-query")).getAttribute("value");

        if(empty.isEmpty()){
            System.out.println("empty");
        }else{
            System.out.println("not empty");
        }



            //wooden spoon should not display





    }
}
