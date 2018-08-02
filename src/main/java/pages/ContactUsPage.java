package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    private final WebDriver driver;

    private By subjectDropdown = By.cssSelector("select#id_contact");
    private By emailTextField = By.cssSelector("input#email");
    private By orderIdTextField = By.cssSelector("input#id_order");
    private By messageTextField = By.cssSelector("textarea#message");
    private By sendButton = By.cssSelector("button#submitMessage");
    private By invalidEmailElement = By.cssSelector(".alert.alert-danger>ol>li");
    private By validEmailElement = By.cssSelector(".alert.alert-success");

    private By emailElementNOK = By.cssSelector(".form-error");
    private By emailElementOK = By.cssSelector(".form-ok");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInContactForm(String subject, String email, String orderId, String message){

        driver.findElement(emailTextField).clear();
        driver.findElement(orderIdTextField).clear();
        driver.findElement(messageTextField).clear();

        Select dropdown = new Select(driver.findElement(subjectDropdown));
        dropdown.selectByVisibleText(subject);

        driver.findElement(emailTextField).sendKeys(email);
        driver.findElement(orderIdTextField).sendKeys(orderId);
        driver.findElement(messageTextField).sendKeys(message);
        //driver.findElement(sendButton).click();
    }

    public boolean emailValidationNOK(){
        return driver.findElement(emailElementNOK).isDisplayed();
    }

    public boolean emailValidationOK(){
        return driver.findElement(emailElementOK).isDisplayed();
    }

    public String successMessage() {
        return driver.findElement(validEmailElement).getText();
    }

    public String errorMessage() {
        return driver.findElement(invalidEmailElement).getText();
    }
}
