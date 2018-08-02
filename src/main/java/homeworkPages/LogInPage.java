package homeworkPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    private final WebDriver driver;

    private By emailTextField = By.id("email");
    private By passwordTextField = By.id("passwd");
    private By sendButton = By.id("SubmitLogin");

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logInSuccesful(String email, String password) {

        driver.findElement(emailTextField).sendKeys(email);
        driver.findElement(passwordTextField).sendKeys(password);
        driver.findElement(sendButton).click();
    }
}
