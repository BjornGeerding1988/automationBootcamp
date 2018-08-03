package dataDriven;

import chapterSix.TestShopScenario;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.Generic;

public class DataDrivenTest extends TestShopScenario {

    @Parameters({"subject", "email", "orderID", "message"})
    @Test
    public void FillInForm(String subject, String email, String orderID, String message) {
        Generic generic = new Generic(driver);
        generic.clickContactButton();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm(subject, email, orderID, message);
        contactUsPage.clickSendButton();

        Assert.assertEquals("Your message has been successfully sent to our team.", contactUsPage.successMessage());
    }
}