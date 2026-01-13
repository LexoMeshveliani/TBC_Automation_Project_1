package ge.tbc.testautomation.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.utils.TestContext;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public SelenideElement initializeNavigation(){
        if (TestContext.isMobile){
            return $(byClassName("tbcx-pw-hamburger-menu"));
        }
        else{
            return $(withText("ჩემთვის"));
        }
    }
    public SelenideElement acceptCookieButton = $x("//button[contains(text(),'თანხმობა')]");

    public SelenideElement locationsButton = $(withText("მისამართები"));

    public SelenideElement convertorButton = $(withText("ვალუტის კურსები"));

    public SelenideElement tbcButton = $x("//button[text()=' თიბისი ']");

    public SelenideElement tbcButtonDesk = $x("//div[text()=' თიბისი ']");

    public SelenideElement accountingButton = $(withText("ფინანსური ანგარიშგება"));
}
