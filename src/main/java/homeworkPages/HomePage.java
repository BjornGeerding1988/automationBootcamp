package homeworkPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    private By loginButton = By.className("login");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLogInPage(){

        driver.findElement(loginButton).click();
    }
}
