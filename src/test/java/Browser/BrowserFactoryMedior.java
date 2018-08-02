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

public class BrowserFactoryMedior {
    public static WebDriver getDriver (String browser) {
        WebDriver driver;

        switch(browser.toLowerCase()) {
            case "firefox":
                return createFireFoxBrowser();
            case "ie":
                return createIEBrowser();
            case "chrome":
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
