package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.constants.Constants;
import ge.tbc.testautomation.constants.CurrencyProvider;
import ge.tbc.testautomation.steps.ConvertorPageSteps;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateLiveCurrencyConversionAccuracy extends BaseTest {
    ConvertorPageSteps convertorSteps = new ConvertorPageSteps();

    @Test(description = "Step 1: Locate Converter", priority = 1)
    public void locateConvertor() {
        homePageSteps.acceptCookie();
        homePageSteps.openNavigation();
        homePageSteps.redirectToConvertor();
    }

    @Test(description = "Step 2: Input Amount", priority = 2,
            dataProvider = "currencyData", dataProviderClass = CurrencyProvider.class)
    public void inputAmount(String currency, double buyRate) {
        convertorSteps.convertForeignToGel(currency, Constants.INPUT_VALUE);
    }

    @Test(description = "Step 3: Verify Calculation", priority = 3,
            dataProvider = "currencyData", dataProviderClass = CurrencyProvider.class)
    public void verifyCalculation(String currency, double buyRate) {
        int nominal = 1;

        if ("JPY".equalsIgnoreCase(currency)) {
            nominal = 100;
        } else if ("CNY".equalsIgnoreCase(currency)
                || "PLN".equalsIgnoreCase(currency)
                || "ILS".equalsIgnoreCase(currency)) {
            nominal = 10;
        }

        double expectedGel = (Constants.INPUT_VALUE * buyRate) / nominal;

        String formattedValue = String.format("%.2f", expectedGel);
        if (formattedValue.contains(".")) {
            formattedValue = formattedValue.replaceAll("0*$", "").replaceAll("\\.$", "");
        }

        convertorSteps.convertForeignToGel(currency, Constants.INPUT_VALUE);

        convertorSteps.getGelAmountField()
                .shouldHave(Condition.value(formattedValue), Duration.ofSeconds(5));
    }
}


