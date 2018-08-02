package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    private final WebDriver driver;

    private By subjectDropdown = By.cssSelector("select#id_contact");
    private By emailTextField = By.cssSelector("input#email");
    private By orderIdTextField = By.cssSelector("input#id_order");
    private By messageTextField = By.cssSelector("textarea#message");
    private By sendButton = By.cssSelector("button#submitMessage");
    private By validEmailElement = By.cssSelector(".alert.alert-success");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInContactForm(String subject, String email, String orderId, String message){

        Select dropdown = new Select(driver.findElement(subjectDropdown));
        dropdown.selectByVisibleText(subject);

        driver.findElement(emailTextField).sendKeys(email);
        driver.findElement(orderIdTextField).sendKeys(orderId);
        driver.findElement(messageTextField).sendKeys(message);
        driver.findElement(sendButton).click();
        driver.findElement(validEmailElement).isDisplayed();
    }
}
