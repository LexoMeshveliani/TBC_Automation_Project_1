package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.steps.CommonStep;
import ge.tbc.testautomation.utils.TestContext;
import org.openqa.selenium.support.ui.Select;

import java.util.stream.Collectors;
import  ge.tbc.testautomation.utils.TestContext;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class ConvertorPage extends CommonStep {
    public SelenideElement table = $(".ag-center-cols-container");
    public SelenideElement mobileTable = $x("//div[@class='tbcx-pw-exchange-rates__cards ng-star-inserted']");

    public ElementsCollection initializeCurrencies(){
        if (TestContext.isMobile()){
            return mobileTable.$$(".tbcx-pw-currency-badge");
        }
        else return table.$$(".tbcx-pw-currency-badge");
    }
    public ElementsCollection initializeValues(){
        if (TestContext.isMobile()){
            return mobileTable.$$x(".//div[text()='ყიდვა']/following-sibling::div");
        }
        else return table.$$("div[col-id='buyRate'] .tbcx-pw-table-cell__content__title.tbcx-pw-title.ng-star-inserted");
    }

    public SelenideElement foreignInput = $("#tbcx-text-input-1");
    public SelenideElement gelInput = $("#tbcx-text-input-2");

    public SelenideElement currencyButton = $x("//button[@class='tbcx-field tbcx-bg-color-high']");
    public SelenideElement dropdown = $(".tbcx-dropdown-popover");
    public ElementsCollection dropdownOptions = $$(".tbcx-dropdown-popover-item__title");
}
