package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FillCartTest {

    @Test
    public void FillCart() throws InterruptedException {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://techblog.polteq.com/testshop/index.php");

        WebElement shoppingCartEmpty = driver.findElement(By.className("ajax_cart_no_product"));
        Assert.assertTrue(shoppingCartEmpty.isDisplayed());

        driver.findElement(By.className("first_item")).click();
        driver.findElement(By.xpath("//a[text() = ' iPod shuffle ']")).click();
        driver.findElement(By.id("add_to_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("layer_cart"))));

        driver.findElement(By.xpath("//span[text() = 'Continue shopping ']")).click();

        WebElement shoppingCartFilled = driver.findElement(By.className("ajax_cart_quantity"));
        Assert.assertEquals(shoppingCartFilled.getText(), "1");

        driver.quit();
    }
}