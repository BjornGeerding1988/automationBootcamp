package homework;

import chapterSix.TestShopScenario;
import homeworkPages.HomePage;
import homeworkPages.MyAccountPage;
import homeworkPages.WishListPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DeleteWishListTest extends TestShopScenario {

    @Test
    public void deleteWishList() {

        HomePage homeworkPage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        WishListPage wishListPage = new WishListPage(driver);
        String wishListName = "Feel the pain";

        homeworkPage.logInSuccesful("bjorn@geerding.com", "1qazxsw2");

        WebElement pageHeaderText = driver.findElement(By.className("page-heading"));
        Assert.assertEquals(pageHeaderText.getText(), "MY ACCOUNT");

        WebElement accountInfoText = driver.findElement(By.className("info-account"));
        Assertions.assertThat(accountInfoText.getText()).as("info-account contains: personal information").contains("personal information");

        myAccountPage.goToWishListPage();

        wishListPage.getWishListTitles();
        wishListPage.addWishList(wishListName);

        Assertions.assertThat(wishListPage.getWishListTitles()).contains(wishListName).as("Test WishList is in the wishlist!");

        wishListPage.removeWishList(wishListName);

        Assertions.assertThat(wishListPage.getWishListTitles()).doesNotContain(wishListName).as("Test WishList is not a wishlist!");
    }
}