package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.HomePage;
import ge.tbc.testautomation.utils.TestContext;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class HomePageSteps extends CommonStep{
    HomePage homePage = new HomePage();
    public void redirectToLocations() {
        if (TestContext.isMobile()) {
            homePage.locationsButton.should(Condition.exist);
            executeJavaScript("arguments[0].click();", homePage.locationsButton);
        } else {
            homePage.locationsButton.shouldBe(Condition.visible).hover().click();
        }
    }

    public void redirectToConvertor() {
        if (TestContext.isMobile()) {
            homePage.convertorButton.should(Condition.exist);
            executeJavaScript("arguments[0].click();", homePage.convertorButton);
        } else {
            homePage.convertorButton.shouldBe(Condition.visible).hover().click();
        }
    }

    public void redirectToAccounting() {
        if (TestContext.isMobile()) {
            homePage.tbcButton.shouldBe(Condition.visible).click();
            homePage.accountingButton.shouldBe(Condition.visible).click();
        } else {
            homePage.tbcButtonDesk.shouldBe(Condition.visible).hover();
            homePage.accountingButton.shouldBe(Condition.visible).click();
        }
    }

    public void redirectToITAcademy(){
        if(TestContext.isMobile()) {
            homePage.tbcButton.shouldBe(Condition.visible).click();
            homePage.educationDropdown
                    .shouldBe(Condition.interactable, Duration.ofSeconds(5))
                    .click();
            homePage.itAcademyButton.shouldBe(Condition.visible).click();
        }
        else{
            homePage.tbcButtonDesk.hover();
            homePage.itAcademyButtonDesk.click();
        }
    }

}
