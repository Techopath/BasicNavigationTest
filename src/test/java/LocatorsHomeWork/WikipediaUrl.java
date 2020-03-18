package LocatorsHomeWork;

import com.cbt.utillities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaUrl {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://wikipedia.org");

        Thread.sleep(2000);
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("selenium webdriver");
        Thread.sleep(2000);
        //using css path
        //WebElement serachButton = driver.findElement(By.cssSelector("html.js-enabled body#www-wikipedia-org.jsl10n-visible div.search-container form#search-form.pure-form fieldset button.pure-button.pure-button-primary-progressive i.sprite.svg-search-icon"));
        //using xpath -> /html/body/div[2]/form/fieldset/button/i
        WebElement serachButton = driver.findElement(By.xpath("/html/body/div[2]/form/fieldset/button/i"));

        serachButton.click();

        Thread.sleep(2000);

        WebElement link = driver.findElement(By.linkText("Selenium (software)"));
        link.click();

        String url = driver.getCurrentUrl();
        System.out.println(url);

        if(url.endsWith("Selenium_(software)")){
            System.out.println(url + " ends with Selenium_(software)");
        }else{
            System.out.println("failed");
            System.out.println(url + " does not end with Selenium_(software) but contains Selenium_(software) ");

        }


    }

}
