package Homework2;

import com.cbt.utillities.BrowserFactory;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) throws InterruptedException {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com", "https://www.westelm.com", "https://walmart.com");



        String passedOrFailed="";
        for (String each: urls) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(each);
            Thread.sleep(2000);

            String title = driver.getTitle().toLowerCase();
            System.out.println("title = " + title);
            String url = driver.getCurrentUrl();
            String[] titleArr = title.split(" ");
            System.out.println("splittedTitle"+Arrays.toString(titleArr));
            for (int i = 0; i < titleArr.length ; i++) {



                if (url.contains(titleArr[i])){
                    passedOrFailed = passedOrFailed+" passed";
                }else{
                    passedOrFailed = passedOrFailed+" failed";
                }

            }

            if (passedOrFailed.contains("passed")){
                System.out.println("passed");
            }else {
                System.out.println("failed");
            }
            driver.close();

        }







    }
}
