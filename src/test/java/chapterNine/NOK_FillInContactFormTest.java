package chapterNine;

import chapterSix.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.Generic;

public class NOK_FillInContactFormTest extends TestShopScenario {

    @Test
    public void FillInForm() {
        Generic generic = new Generic(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        generic.clickContactButton();
        contactUsPage.fillInContactForm("Customer service","nope", "4321234", "Help!");

        Assert.assertEquals("Invalid email address.", contactUsPage.errorMessage());

    }
}
