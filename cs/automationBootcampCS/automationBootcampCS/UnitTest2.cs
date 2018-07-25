using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace automationBootcampCS
{
    [TestClass]
    public class FirstSeleniumTest
    {
        [TestMethod]
        public void logInSuccessful()
        {
            IWebDriver driver = new ChromeDriver();

            driver.Manage().Window.Maximize();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");
            driver.FindElement(By.ClassName("login")).Click();

 
            driver.FindElement(By.Id("email")).SendKeys("blabla@test.com");
            driver.FindElement(By.Id("passwd")).SendKeys("test1234");
            driver.FindElement(By.Id("SubmitLogin")).Click();

            String pageHeaderText = driver.FindElement(By.ClassName("page-heading")).Text;
            Assert.AreEqual("MY ACCOUNT ", pageHeaderText);

            IWebElement accountInfoText = driver.FindElement(By.ClassName("info-account"));
            accountInfoText.Text.Contains("personal information");

            driver.Close();
        }
    }
}