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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DataDrivenLogInCSV extends TestShopScenario {

        String csvFile = "C:\\Users\\Bjorn\\Documents\\_Polteq\\Automation_Bootcamp\\testDataCSV\\testDataCSV.csv";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

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
    public Iterator<Object []> provider( ) throws InterruptedException, IOException {
        List<Object []> testCases = new ArrayList<>();
        String[] data;

        //this loop is pseudo code
        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            // use comma as separator
            data = line.split(cvsSplitBy);
            testCases.add(data);
        }

        return testCases.iterator();
    }
}