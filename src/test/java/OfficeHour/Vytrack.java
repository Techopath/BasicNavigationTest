package OfficeHour;

import com.cbt.utillities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class Vytrack {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://qa3.vytrack.com/");

        WebElement email = driver.findElement(By.id("prependedInput"));
        email.sendKeys("SalesManager110");

        Thread.sleep(2000);

        WebElement pass = driver.findElement(By.id("prependedInput2"));
        pass.sendKeys("UserUser123");
        Thread.sleep(2000);
        pass.submit();

        WebElement contacts = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        //span[.='Contacts']/following_siblings::a
        //(//span[.=‘Contacts’])[2]
        //a[@href='/contact])[4]
        Thread.sleep(3000);
        contacts.click();

        Thread.sleep(2000);

        WebElement createContact = driver.findElement(By.linkText("Create Contact"));

        createContact.click();

        String currentTitle = driver.getTitle();
        String expected = "title";

        if (currentTitle.equals(expected)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
            System.out.println("currentTitle: "+currentTitle);
            System.out.println("expected = " + expected);

            HashMap<String, String> contact1 = new HashMap<>();

            contact1.put("First name", "John");
            contact1.put("Last name", "Smith");
            contact1.put("phone", "571-412-75-45");
            contact1.put("Street", "Leesburg pike 25");
            contact1.put("city", "Tysons");
            contact1.put("State", "Va");
            contact1.put("zipCode", "22232");
            contact1.put("sales group", "true");
            contact1.put("Country", "United States");

            System.out.println("Contact1 map: "+contact1);

}


    }
}


