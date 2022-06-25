package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class hooks {
    private static WebDriver driver;

    @Before
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://somosmakers.co/");
        driver.manage().window().maximize();
    }

   @After
   public void afterSuite() {
       if(null != driver) {
        driver.close();
        driver.quit();
       }
    }

   public static WebDriver getDriver() {
        return driver;
    }
}

