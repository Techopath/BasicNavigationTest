package LocatorsHomeWork;

import com.cbt.utillities.BrowserFactory;
import com.cbt.utillities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackShortCutFunctionality extends StringUtility{
    public static void main(String[] args) throws InterruptedException {
        shortCutForVyTrack();

    }
    /*
        1. Open browser
    2. Go to Vytrack login page
    3. Login as a sales manager
    4. Verify Dashboard page is open
    5. Click on Shortcuts icon
    6. Click on link See full list
    7. Click on link Opportunities
    8. Verify Open opportunities page is open
    9. Click on Shortcuts icon
    10. Click on link See full list
    11. Click on link Vehicle Service Logs
    12. Verify error message text is You do not have
    permission to perform this action.
    13. Verify Shortcut Actions List page is still open
         */
    //we create this method so that we can call it from another class
    public static void shortCutForVyTrack() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://qa3.vytrack.com/user/login");
        //SalesManager110
        //UserUser123

        WebElement email = driver.findElement(By.id("prependedInput"));
        email.sendKeys("SalesManager110");

        Thread.sleep(2000);

        WebElement pass = driver.findElement(By.id("prependedInput2"));
        pass.sendKeys("UserUser123"+ Keys.ENTER);
        Thread.sleep(3000);
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        //verifyStrings(expectedTitle, actualTitle);
        //StringUtility.verifyEquals(expectedTitle,actualTitle); //we can use className.methodName to call the method
        verifyEquals(expectedTitle,actualTitle); //or extend subclass to parent class and use all the properties from parent class.
        //we called from another class by extends that class to this one.

        WebElement shortcutIcon = driver.findElement(By.cssSelector("a[title='Shortcuts']"));
        shortcutIcon.click();
        Thread.sleep(3000);
        WebElement allLinks = driver.findElement(By.linkText("See full list"));
        allLinks.click();

        Thread.sleep(3000);
        WebElement opportunities = driver.findElement(By.linkText("Opportunities"));

        opportunities.click();

        Thread.sleep(2000);

        verifyEquals("Open Opportunities", driver.getTitle());
        //Thread.sleep(2000);
        shortcutIcon.click();
        Thread.sleep(2000);
        allLinks.click();
        Thread.sleep(2000);
        WebElement vslogs = driver.findElement(By.linkText("Vehicle Services Logs"));
        vslogs.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.cssSelector(".message"));

        System.out.println(errorMessage.getText());

        verifyEquals("You do not have permission to perform this action.",errorMessage.getText());

        verifyEquals("Shortcut Actions List", driver.getTitle());

        driver.quit();

    }

    private static void verifyStrings(String expectedTitle, String actualTitle) {
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
        }
    }
}
