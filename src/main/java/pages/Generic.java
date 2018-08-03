package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Generic {

    private final WebDriver driver;

    private By contactButton = By.cssSelector("li#header_link_contact > a");

    public Generic(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContactButton(){

        driver.findElement(contactButton).click();

    }
}
