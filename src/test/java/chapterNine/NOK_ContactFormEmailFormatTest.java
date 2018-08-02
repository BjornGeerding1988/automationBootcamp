package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.Generic;

public class NOK_ContactFormEmailFormatTest extends TestShopScenario {

    @Test
    public void FillInForm() {
        Generic generic = new Generic(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        generic.clickContactButton();
        contactUsPage.fillInContactForm("Customer service","nope", "4321234", "Help!");

        Assertions.assertThat(contactUsPage.emailValidationNOK()).isTrue();

        contactUsPage.fillInContactForm("Customer service","nope@correct.com", "4321234", "This email address does work");

        Assertions.assertThat(contactUsPage.emailValidationOK()).isTrue();
    }
}