package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.ConvertorPage;

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

    public String expectedGelValue(String currency, int foreignAmount, double buyRate) {
        int nominal = nominalFor(currency);
        double expectedGel = (foreignAmount * buyRate) / nominal;
        return formatLikeUi(expectedGel);
    }

    private int nominalFor(String currency) {
        String c = currency.trim().toUpperCase();

        if ("JPY".equals(c)) {
            return 100;
        }
        if ("CNY".equals(c) || "PLN".equals(c) || "ILS".equals(c)) {
            return 10;
        }
        return 1;
    }

    private String formatLikeUi(double value) {
        String formatted = String.format("%.2f", value);
        if (formatted.contains(".")) {
            formatted = formatted.replaceAll("0*$", "").replaceAll("\\.$", "");
        }
        return formatted;
    }
}

