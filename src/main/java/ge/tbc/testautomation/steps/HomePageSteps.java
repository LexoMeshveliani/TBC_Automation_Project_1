package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.HomePage;
import ge.tbc.testautomation.utils.TestContext;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class HomePageSteps {
    HomePage homePage = new HomePage();
    public void openNavigation(){
        if(TestContext.isMobile){
            homePage.initializeNavigation().click();
        }
        else{
            homePage.initializeNavigation().hover();
        }
    }
    public void redirectToLocations() {
        if (TestContext.isMobile) {
            homePage.locationsButton.should(Condition.exist);
            executeJavaScript("arguments[0].click();", homePage.locationsButton);
        } else {
            homePage.locationsButton.shouldBe(Condition.visible).hover().click();
        }
    }

    public void acceptCookie(){
        homePage.acceptCookieButton.click();
    }

    public void redirectToConvertor() {
        if (TestContext.isMobile) {
            homePage.convertorButton.should(Condition.exist);
            executeJavaScript("arguments[0].click();", homePage.convertorButton);
        } else {
            homePage.convertorButton.shouldBe(Condition.visible).hover().click();
        }
    }

}
