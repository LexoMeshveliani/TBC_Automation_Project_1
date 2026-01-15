package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.constants.Constants;
import ge.tbc.testautomation.pages.AccountingPage;
import ge.tbc.testautomation.steps.*;
import ge.tbc.testautomation.utils.TestContext;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.internal.ConfigurationMethod;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    HomePageSteps homePageSteps = new HomePageSteps();
    ITAcademySteps steps = new ITAcademySteps();
    CommonStep commonStep = new CommonStep();
    LocationsPageSteps locationsPageSteps = new LocationsPageSteps();
    ConvertorPageSteps convertorSteps = new ConvertorPageSteps();
    AccountingPageSteps accountingPageSteps = new AccountingPageSteps();
    AccountingPage page = new AccountingPage();


    @Parameters(value = "device")
    @BeforeClass
    public void setUp(String device){
        TestContext.setDevice(device);

        Configuration.browser = "chrome";
        open(Constants.TBC_URL);

        if (TestContext.isMobile()){
            WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(430, 932));
        } else {
            WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(1366, 768));
        }

        commonStep.cookieEater();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        try {
            webdriver().object().manage().deleteAllCookies();
        } finally {
            closeWebDriver();
            TestContext.clear();
        }
    }

}
