package LocatorsHomeWork;

import com.cbt.utillities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrackTitleTest {

    public static void main(String[] args) throws InterruptedException {
       titleTest();
    }

    private static void titleTest() throws InterruptedException{
         /*
        1. Open browser
        2. Go to Vytrack login page
        3. Login as any user
        4. Click on your name on top right
        5. Click on My Configuration
        6. Verify that page title starts with the same name on top
            right
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://qa3.vytrack.com/user/login");
        //SalesManager110
        //UserUser123

        WebElement email = driver.findElement(By.id("prependedInput"));
        email.sendKeys("SalesManager110");

        Thread.sleep(2000);

        WebElement pass = driver.findElement(By.id("prependedInput2"));
        pass.sendKeys("UserUser123");

        Thread.sleep(2000);

        pass.submit(); //using submit it lets you login without locating submit element.

//        WebElement login = driver.findElement(By.id("_submit")); //this way is also possible
//
//        login.click();

        Thread.sleep(2000);

        //WebElement name = driver.findElement(By.className("dropdown-toggle"));

        //Using css locator method:
        //tag[attribute = 'value'] -> for attribute and value
        //for Class -> tag.class => a.class='dropdown-toggle'

        WebElement name = driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));


        name.click();

        Thread.sleep(1000);

        //WebElement config = driver.findElement(By.linkText("My Configuration"));
        //ul.dropdown-menu a[href='/config/user/profile']
        //WebElement config = driver.findElement(By.cssSelector("ul.dropdown-menu a[href='/config/user/profile']")); //this works with space.


       WebElement config = driver.findElement(By.cssSelector("ul.dropdown-menu>li>a[href='/config/user/profile']"));

        //a[.='My Configuration'] -> xpath
        //WebElement config = driver.findElement(By.xpath("//a[.='My Configuration']")); //using text works with xpath  not css

        config.click();

        String pageTitle = driver.getTitle();

        System.out.println(name.getText());

        if (pageTitle.startsWith(name.getText())){
            System.out.println("pass");
        }else {
            System.out.println("fail");
            System.out.println("pageTitle = " + pageTitle);
        }







    }


}
