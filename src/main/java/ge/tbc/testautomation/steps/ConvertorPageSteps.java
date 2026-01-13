package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.PartialText;
import ge.tbc.testautomation.pages.ConvertorPage;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class ConvertorPageSteps {
    ConvertorPage page = new ConvertorPage();

    public void selectCurrency(String currency) {
        page.currencyButton.click();
        page.dropdownOptions.findBy(Condition.text(currency)).click();

        page.dropdown.should(Condition.disappear);
        page.currencyButton.shouldHave(Condition.text(currency));
    }

    public void enterForeignAmount(int amount) {
        page.foreignInput.shouldBe(Condition.visible);
        page.foreignInput.setValue(String.valueOf(amount));
        page.foreignInput.shouldHave(Condition.value(String.valueOf(amount)));
    }

    public void convertForeignToGel(String currency, int amount) {
        selectCurrency(currency);
        enterForeignAmount(amount);
    }

    public SelenideElement getGelAmountField() {
        return page.gelInput;
    }
}

