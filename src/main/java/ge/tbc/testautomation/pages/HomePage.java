package ge.tbc.testautomation.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.steps.CommonStep;
import ge.tbc.testautomation.utils.TestContext;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage{
    public SelenideElement burgerMenu = $(byClassName("tbcx-pw-hamburger-menu"));

    public SelenideElement navigationForMe = $x("//div[contains(text(),'ჩემთვის')]");

    public SelenideElement rejectCookieButton = $x("//button[contains(text(),'უარყოფა')]");

    public SelenideElement locationsButton = $(withText("მისამართები"));

    public SelenideElement convertorButton = $(withText("ვალუტის კურსები"));


    public SelenideElement tbcButton = $x("//button[text()=' თიბისი ']");

    public SelenideElement tbcButtonDesk = $x("//div[text()=' თიბისი ']");

    public SelenideElement accountingButton = $(withText("ფინანსური ანგარიშგება"));


    public SelenideElement educationDropdown = $x("(//div[contains(@class, 'tbc-accordion')]//span[text()='განათლება'])[1]");

    public SelenideElement itAcademyButtonDesk = $(withTagAndText("span", "IT აკადემია"));

    public SelenideElement itAcademyButton = $x("//div[contains(@class,'tbc-accordion__content')]//span[contains(text(), 'IT აკადემია')]");
}
