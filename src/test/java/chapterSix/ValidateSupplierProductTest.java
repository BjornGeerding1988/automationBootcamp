package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class ValidateSupplierProductTest extends TestShopScenario {

    @Test
    public void AdjustPersonalInformation() throws InterruptedException {

        Select supplierDropdown = new Select(driver.findElement(By.name("supplier_list")));
        supplierDropdown.selectByVisibleText("AppleStore");

    }
}
