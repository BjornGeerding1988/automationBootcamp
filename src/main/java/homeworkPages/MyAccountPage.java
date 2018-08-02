package homeworkPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private final WebDriver driver;

    private By wishListButton = By.className("icon-heart");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToWishListPage(){

        driver.findElement(wishListButton).click();
    }
}
