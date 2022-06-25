package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class ContactPage {
    private WebDriver driver;

    @FindBy(css="[href='tel:+57%20(315) 369 6145']")
    WebElement cellPhoneCustomerService;

    @FindBy(id= "et_pb_contact_first_0")
    WebElement nameField;

    @FindBy(id= "et_pb_contact_last_0")
    WebElement lastNameField;

    @FindBy(id= "et_pb_contact_email_0")
    WebElement emailField;

    @FindBy(id= "et_pb_contact_phone_0")
    WebElement phoneField;

    @FindBy(id= "et_pb_contact_message_0")
    WebElement messageField;

    @FindBy(name= "et_builder_submit_button")
    WebElement submitButton;


    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCellPhoneCustomerService(){
        BasePage element = new BasePage(driver);
        WebElement getCellPhone = element.waitForElementToAppear(cellPhoneCustomerService);
        return getCellPhone.getText();
    }

    public void setName(String name){
        BasePage element = new BasePage(driver);
        WebElement writeName = element.waitForElementToAppear(nameField);
        writeName.sendKeys(name);
    }

    public void setLastName(String lastname){
        BasePage element = new BasePage(driver);
        WebElement writeLastName = element.waitForElementToAppear(lastNameField);
        writeLastName.sendKeys(lastname);
    }

    public void setPhone(String phone){
        BasePage element = new BasePage(driver);
        WebElement writePhone = element.waitForElementToAppear(phoneField);
        writePhone.sendKeys(phone);
    }

    public void setEmail(String email){
        BasePage element = new BasePage(driver);
        WebElement writeEmail = element.waitForElementToAppear(emailField);
        writeEmail.sendKeys(email);
    }

    public void setMessage(String message){
        BasePage element = new BasePage(driver);
        WebElement writeMessage = element.waitForElementToAppear(messageField);
        writeMessage.sendKeys(message);
    }

    public void takeScreenshoots() throws IOException {
        BasePage element = new BasePage(driver);
        element.takeSnapShot("Downloads.png");
    }

    public void clickSubmitButton(){
        BasePage element = new BasePage(driver);
        WebElement clickButton = element.waitForElementToAppear(submitButton);
        clickButton.click();
    }
}

