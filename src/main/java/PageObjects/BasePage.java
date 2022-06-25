package PageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {
    private final WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForElementToAppear(WebElement element) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            return wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
        } catch (Exception e) {
            e.printStackTrace();
            return element;
        }
    }

    public void takeSnapShot(String fileWithPath) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(fileWithPath));
    }
}
