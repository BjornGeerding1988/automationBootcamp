package chapterNine;

import chapterSix.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class FillInContactFormTest extends TestShopScenario {

    @Test
    public void FillInForm() {
        driver.findElement(By.cssSelector("li#header_link_contact > a")).click();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm("Customer service","blabla@test.com", "4321234", "Ipod defect while lifting, need new one");

    }
}
