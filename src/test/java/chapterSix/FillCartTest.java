package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FillCartTest {

    @Test
    public void FillCart() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://techblog.polteq.com/testshop/index.php");

        WebElement shoppingCartEmpty = driver.findElement(By.className("ajax_cart_no_product"));
        Assert.assertTrue(shoppingCartEmpty.isDisplayed());

        driver.quit();
    }
}
