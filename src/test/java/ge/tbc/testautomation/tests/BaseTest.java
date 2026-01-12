package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import ge.tbc.testautomation.constants.Constants;
import ge.tbc.testautomation.steps.HomePageSteps;
import ge.tbc.testautomation.utils.TestContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.internal.ConfigurationMethod;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    HomePageSteps homePageSteps = new HomePageSteps();

    @Parameters(value = "device")
    @BeforeClass
    public void setUp(String device){
        Configuration.browser = "chrome";
        TestContext.isMobile = device.equalsIgnoreCase("mobile");
        if (TestContext.isMobile){
            Configuration.browserSize = "430x932";
        }
        else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            Configuration.browserCapabilities = options;
        }

        open(Constants.TBC_URL);
    }

    @AfterClass
    public void tearDown(){
        closeWebDriver();
    }
}
