package Browser;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Browser.BrowserFactoryAdvanced.Browser.*;

public class TestShopScenarioBrowserFactory {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactoryAdvanced.getDriver(CHROME);

        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
