package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignOutTest {

    @Test
    public void SignInandSignOut() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys("blabla@test.com");
        driver.findElement(By.id("passwd")).sendKeys("test1234");
        driver.findElement(By.id("SubmitLogin")).click();

        WebElement username = driver.findElement(By.className("account"));
        Assert.assertEquals(username.getText(), "Test Tester");

        WebElement signOutButton = driver.findElement(By.className("logout"));
        Assert.assertEquals(signOutButton.getText(), "Sign out");

        WebElement pageHeaderText = driver.findElement(By.className("page-heading"));
        Assert.assertEquals(pageHeaderText.getText(), "MY ACCOUNT");

        WebElement accountInfoText = driver.findElement(By.className("info-account"));
        Assertions.assertThat(accountInfoText.getText()).as("info-account contains: personal information").contains("personal information");

        driver.findElement(By.className("logout")).click();

        WebElement signInButton = driver.findElement(By.className("login"));
        Assert.assertEquals(signInButton.getText(), "Sign in");

        driver.quit();
    }
}
