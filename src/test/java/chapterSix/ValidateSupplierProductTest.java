package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class ValidateSupplierProductTest extends TestShopScenario {

    @Test
    public void AdjustPersonalInformation() throws InterruptedException {

        Select supplierDropdown = new Select(driver.findElement(By.name("supplier_list")));
        supplierDropdown.selectByVisibleText("AppleStore");

        WebElement productList = driver.findElement((By.id("product_list")));
        List<WebElement> productNames = productList.findElements(By.className("product-name"));
        List<String> productNamesStrings = new ArrayList<String>();
        //boolean productFound = false;

        for (WebElement element : productNames) {
            productNamesStrings.add(element.getText());
            //System.out.println(element.getText());
            if (element.getText().contains("MacBook Air")) {
                //productFound = true;
                break;
            }
        }

        Assertions.assertThat(productNamesStrings).contains("MacBook Air");

        //Assertions.assertThat(productFound).as("Product is not found").isTrue();

//        List<WebElement> productList = driver.findElements(By.id("product_list"));
//
//        for (WebElement element: productList) {
//            if (element.getText().contains("MacBook Air")) {
//                System.out.println("MacBook Air Found!");
//            } else {
//                System.out.println("NOT FOUND!");
//            }
    }
}
