package homework;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class DeleteWishListLineair {

    @Test
    public void deleteWishListTest() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys("bjorn@geerding.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        WebElement pageHeaderText = driver.findElement(By.className("page-heading"));
        Assert.assertEquals(pageHeaderText.getText(), "MY ACCOUNT");

        WebElement accountInfoText = driver.findElement(By.className("info-account"));
        Assertions.assertThat(accountInfoText.getText()).as("info-account contains: personal information").contains("personal information");

        driver.findElement(By.className("icon-heart")).click();

        List<WebElement> wishListTitles = driver.findElements(By.cssSelector("[id=block-history] tbody tr td:nth-child(1)"));
        List<String> wishListNamesStrings = new ArrayList<String>();

        String wishListName = "Test WishList";

        WebDriverWait wait = new WebDriverWait(driver, 10);

        for (WebElement element : wishListTitles) {
            wishListNamesStrings.add(element.getText());
        }

        if (!wishListNamesStrings.contains(wishListName)) {
            driver.findElement(By.id("name")).sendKeys(wishListName);
            driver.findElement(By.name("submitWishlist")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id=block-history]")));

            wishListTitles.clear();
            wishListNamesStrings.clear();
            wishListTitles = driver.findElements(By.cssSelector("[id=block-history] tbody tr td:nth-child(1)"));

            for (WebElement element : wishListTitles) {
                wishListNamesStrings.add(element.getText());
            }
        }

        Assertions.assertThat(wishListNamesStrings).contains(wishListName).as("Test WishList is in the wishlist!");

        int indexOfWishList = wishListNamesStrings.indexOf(wishListName) + 1;
        int beforeRemovingWishList = wishListNamesStrings.size();

        if (indexOfWishList > 0) {
            driver.findElement(By.cssSelector("#block-history tr:nth-child(" + indexOfWishList + ") .icon-remove")).click();

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            wishListNamesStrings.remove(wishListName);
        }

        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("[id=block-history] tbody tr td:nth-child(1)"), beforeRemovingWishList));

        Assertions.assertThat(wishListNamesStrings).doesNotContain(wishListName).as("Test WishList is not a wishlist!");

        driver.quit();
    }
}
