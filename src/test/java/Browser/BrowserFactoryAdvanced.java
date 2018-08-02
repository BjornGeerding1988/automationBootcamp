package Browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserFactoryAdvanced {

    public enum Browser {
        CHROME(), FIREFOX(), INTERNET_EXPLORER()
    }

    public static WebDriver getDriver(Browser browser) {
        WebDriver driver;

        switch (browser) {
            case FIREFOX:
                return createFireFoxBrowser();
            case INTERNET_EXPLORER:
                return createIEBrowser();
            case CHROME:
                return createChromeBrowser();
            default:
                driver = new ChromeDriver();
        }
        return driver;
    }

    private static WebDriver createChromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-infobars");
        //Capabilities can used for WebDriver capabilities ie: proxy
        options.setCapability("chrome.switches", "--verbose");
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(options);
    }

    private static WebDriver createIEBrowser() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        InternetExplorerDriverManager.getInstance().setup();
        return new InternetExplorerDriver(options);
    }

    private static WebDriver createFireFoxBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver(options);
    }
}
