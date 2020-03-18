package LocatorsHomeWork;

import com.cbt.utillities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbaySearchTest {

    public static void main(String[] args) throws InterruptedException {
        ebayTest();
    }

    /*
    2. Go to https://ebay.com
3. Search for wooden spoon
4. Save the total number of results
5. Click on link All under the categories on the left menu
6. Verify that number of results is bigger than the number in step 4
7. Navigate back to previous research results page
8. Verify that wooden spoon is still displayed in the search box
9. Navigate back to home page
10. Verify that search box is blank
     */
    private static void ebayTest() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
//2
        driver.get("http://ebay.com");
        Thread.sleep(2000);
   //3
        WebElement input = driver.findElement(By.id("gh-ac"));
        input.sendKeys("wooden spoon"+ Keys.ENTER);
        //input.sendKeys("wooden spoon" + Keys.ENTER);
        Thread.sleep(2000);
     //4
        WebElement countEl = driver.findElement(By.cssSelector("h1>span"));
        String count = countEl.getText();
        System.out.println(count);

//        int countN = Integer.parseInt(count.replace(",",""));
//        System.out.println(countN);
        int countOne = Integer.parseInt(count.replace(",", ""));
        System.out.println(countOne);
//5
        WebElement all = driver.findElement(By.linkText("All"));
        all.click();
        Thread.sleep(2000);

        // re initialize the element that is throwing the stateelementexception
 //6
        countEl = driver.findElement(By.cssSelector("h1>span"));
        count = countEl.getText();
        System.out.println(count);

        int countTwo = Integer.parseInt(count.replace(",", ""));
        System.out.println(countTwo);

        if (countOne<countTwo){
            System.out.println(countTwo+" is bigger than "+countOne);
        }else{
            System.out.println("fail");
        }
        //7
        driver.navigate().back();

        //8 -> we will need

        /*
        how to get a text of an element in selenium?
        1. element.getText();
        2. element.getAttribute('value');
        3. element.getAttribute()
         */
        input = driver.findElement(By.id("gh-ac"));
        String woodenSpoon = input.getAttribute("value");

        if (!woodenSpoon.isEmpty()){
            System.out.println(woodenSpoon+" exists");
        }else{
            System.out.println("empty");
        }

        //9
        driver.navigate().back();

        woodenSpoon = input.getAttribute("value");
        System.out.println("woodenSpoon = " + woodenSpoon);

        if (woodenSpoon.isEmpty()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected a blank value");
            System.out.println("Actual: " + woodenSpoon);
        }

        driver.quit();









    }
}
