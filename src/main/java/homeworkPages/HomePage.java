package homeworkPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    private By loginButton = By.className("login");
    private By emailTextField = By.id("email");
    private By passwordTextField = By.id("passwd");
    private By sendButton = By.id("SubmitLogin");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void logInSuccesful(String email, String password){

        driver.findElement(loginButton).click();
        driver.findElement(emailTextField).sendKeys(email);
        driver.findElement(passwordTextField).sendKeys(password);
        driver.findElement(sendButton).click();
    }
}
