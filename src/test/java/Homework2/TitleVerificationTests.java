package Homework2;

import com.cbt.utillities.BrowserFactory;
;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerificationTests {

    public static void main(String[] args) throws InterruptedException {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login","http://google.com");
//                "http://google.com",
//                "http://gmail.com";

        WebDriver driver = BrowserFactory.getDriver("chrome");
        List<String> urlsTitle = new ArrayList<>();
        String titlesStr = null;
        for (int i = 0; i < urls.size(); i++) {
            driver.get(urls.get(i));
            Thread.sleep(3000);
            titlesStr = driver.getTitle();

            urlsTitle.add(titlesStr);

            if(driver.getCurrentUrl().startsWith("http://practice.cybertekschool.com")){
                System.out.println("Correct");
            }else{
                System.out.println("Wrong");
            }

        }


        System.out.println(urlsTitle.toString());

        for (int j = 0; j < urlsTitle.size()-1; j++) {
            if(urlsTitle.get(j).equals(urlsTitle.get(j+1))){
                System.out.println("passed");
            }else {
                System.out.println("failed");
                System.out.println(urlsTitle.get(j+1));
            }
        }

        driver.close();



    }
}
