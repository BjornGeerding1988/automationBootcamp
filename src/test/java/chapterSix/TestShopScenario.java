package chapterSix;

import com.opencsv.CSVReader;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class TestShopScenario {

    protected static final String FILE_PATH = "C:\\Users\\Bjorn\\Documents\\_Polteq\\Automation_Bootcamp\\testDataCSV\\testDataCSV.csv";
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();

        driver.get("https://techblog.polteq.com/testshop/index.php");

        driver.manage().window().maximize();
    }

    @DataProvider
        public Object[] getData() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(FILE_PATH));
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            String email = nextLine[0];
            String password = nextLine[1];
        }
        return nextLine;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
