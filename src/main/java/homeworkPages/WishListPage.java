package homeworkPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class WishListPage {

    private final WebDriver driver;

    private By wishListTitles = By.cssSelector("[id=block-history] tbody tr td:nth-child(1)");
    private List<String> wishListNamesStrings = new ArrayList<String>();

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getWishListTitles(){
        wishListNamesStrings.clear();
        List<WebElement> wishLists = driver.findElements(wishListTitles);

        for (WebElement element : wishLists) {
            wishListNamesStrings.add(element.getText());
        }
        return wishListNamesStrings;
    }

    public void addWishList(String wishListName) {
        if (!wishListNamesStrings.contains(wishListName)) {
            driver.findElement(By.id("name")).sendKeys(wishListName);
            driver.findElement(By.name("submitWishlist")).click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id=block-history]")));

            List<WebElement> wishLists = driver.findElements(wishListTitles);

            wishLists.clear();

            getWishListTitles();
        }
    }

    public void removeWishList(String wishListName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        int wishListIndex = wishListNamesStrings.indexOf(wishListName) + 1;

        if (wishListIndex> 0) {
            driver.findElement(By.cssSelector("#block-history tr:nth-child(" + (wishListIndex) + ") .icon-remove")).click();

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            wishListNamesStrings.remove(wishListName);
        }

        wait.until(ExpectedConditions.numberOfElementsToBe(wishListTitles, wishListNamesStrings.size()));

    }
}
