package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.pages.HomePage;
import ge.tbc.testautomation.utils.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonStep {
    HomePage homePage = new HomePage();

    public void openNavigation(){
        if(TestContext.isMobile()){
            homePage.burgerMenu.shouldBe(Condition.visible).click();
        }
        else{
            homePage.navigationForMe.shouldBe(Condition.visible).hover();
        }
    }

    public void cookieEater(){
        homePage.rejectCookieButton.shouldBe(Condition.visible).click();
    }
}
