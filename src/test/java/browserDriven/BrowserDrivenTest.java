package browserDriven;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.Generic;

public class BrowserDrivenTest extends TestShopScenarioBrowserDriven {

    @Test
    public void FillInForm() {
        Generic generic = new Generic(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        generic.clickContactButton();
        contactUsPage.fillInContactForm("Customer service","blabla@test.com", "4321234", "Ipod defect while lifting, need new one");

        contactUsPage.clickSendButton();

        Assert.assertEquals("Your message has been successfully sent to our team.", contactUsPage.successMessage());

    }
}
