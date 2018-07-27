package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class AdjustPersonalInfoTest extends TestShopScenario {

    @Test
    public void AdjustPersonalInformation() throws InterruptedException {
        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys("blabla@test.com");
        driver.findElement(By.id("passwd")).sendKeys("test1234");
        driver.findElement(By.id("SubmitLogin")).click();

        driver.findElement(By.className("icon-user")).click();

        WebElement firstName = driver.findElement(By.id("firstname"));
        WebElement lastName = driver.findElement(By.id("lastname"));

        String newFirstName;
        String newLastName;

        if (firstName.getAttribute("value").equals("Test") && firstName.getAttribute("value").equals("Tester")) {
            newFirstName = "Bjorn";
            newLastName = "Geerding";
        } else {
            newFirstName = "Test";
            newLastName = "Tester";
        }

        firstName.clear();
        firstName.sendKeys(newFirstName);
        lastName.clear();
        lastName.sendKeys(newLastName);

        driver.findElement(By.id("old_passwd")).sendKeys("test1234");
        driver.findElement(By.name("submitIdentity")).click();

        Assert.assertEquals(driver.findElement(By.className("alert-success")).getText(), "Your personal information has been successfully updated.");
    }
}
