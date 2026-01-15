package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Sleeper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AccountingPage {
    public SelenideElement nbgContainer = $x("//app-reports-section[.//h2[normalize-space()='სებ ანგარიშგება']]");
    public SelenideElement annualAccountingContainer = $x("//app-reports-section[.//h2[normalize-space()='წლიური ანგარიში']]");
    public SelenideElement csrContainer = $x("//app-reports-section[.//h2[normalize-space()='კორპორაციული სოციალური პასუხისმგებლობის ანგარიში']]");
    public SelenideElement sustainableContainer = $x("//app-reports-section[.//h2[contains(., 'მდგრადი განვითარების')]]");

    public SelenideElement getYearBtn(SelenideElement container, String year) {
        return container.$x(".//span[contains(text(), '" + year + "')]");
    }
    public SelenideElement getMoreBtn(SelenideElement container) {
        return container.$(withText("მეტის ნახვა"));
    }
}
