package dataDriven;

import Browser.TestShopScenarioBrowserFactory;
import homeworkPages.HomePage;
import homeworkPages.LogInPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenLogIn extends TestShopScenarioBrowserFactory {

    @Parameters({"email", "password"})
    @Test
    public void LogInSuccessful(String email, String password) {
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);

        homePage.goToLogInPage();
        logInPage.logInSuccesful(email, password);

        WebElement pageHeaderText = driver.findElement(By.className("page-heading"));
        Assert.assertEquals(pageHeaderText.getText(), "MY ACCOUNT");

        WebElement accountInfoText = driver.findElement(By.className("info-account"));
        Assertions.assertThat(accountInfoText.getText()).as("info-account contains: personal information").contains("personal information");
    }
}