package dataDriven;

import chapterSix.TestShopScenario;
import com.opencsv.CSVReader;
import homeworkPages.HomePage;
import homeworkPages.LogInPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DataDrivenLogInCSV extends TestShopScenario {

    public String[] ReadfromCSV() throws InterruptedException, IOException {

        String[] data= null;
        String csvFile = "C:\\Users\\Bjorn\\Documents\\_Polteq\\Automation_Bootcamp\\testDataCSV\\testDataCSV.csv";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                data= line.split(cvsSplitBy);
            }
        System.out.println("Done");
        return data;
    }

    @Test(dataProvider = "test")
    public void LogInSuccessful(String email, String password) {

        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);

        homePage.goToLogInPage();
        logInPage.logInSuccesful(email, password);

        WebElement pageHeaderText = driver.findElement(By.className("page-heading"));
        Assert.assertEquals(pageHeaderText.getText(), "MY ACCOUNT");

        WebElement accountInfoText = driver.findElement(By.className("info-account"));
        Assertions.assertThat(accountInfoText.getText()).as("info-account contains: personal information").contains("personal information");
    }

    @DataProvider(name = "test")
    public Object[][] provider() throws IOException, InterruptedException {

        Object[][] returnObject ;

        String[] checkpoint = ReadfromCSV();

        returnObject = new Object[][]{checkpoint };
        return returnObject;
    }

}