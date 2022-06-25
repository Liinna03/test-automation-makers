package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MakersPage {
    private WebDriver driver;

    @FindBy(css="[href='https://somosmakers.co'] > .et_pb_image_wrap")
    WebElement logoMakers;

    @FindBy(css= "#menu-principal > .et_pb_menu_page_id-211")
    WebElement contactLink;


    public MakersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String confirmPage(){
        BasePage getRequest = new BasePage(driver);
        WebElement confirmLogo = getRequest.waitForElementToAppear(logoMakers);
        String url = driver.getCurrentUrl();
        return url;
    }

    public void clickContact(){
        BasePage element = new BasePage(driver);
        WebElement clickButton = element.waitForElementToAppear(contactLink);
        clickButton.click();
    }
}

