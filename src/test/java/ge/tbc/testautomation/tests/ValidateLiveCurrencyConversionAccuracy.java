package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.constants.Constants;
import ge.tbc.testautomation.utils.CurrencyProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateLiveCurrencyConversionAccuracy extends BaseTest {


    @Test(description = "Step 1: Locate Converter", priority = 1)
    public void locateConvertor() {
        commonStep.openNavigation();
        homePageSteps.redirectToConvertor();
    }

    @Test(description = "Input Amount", priority = 2,
            dataProvider = "currencyData", dataProviderClass = CurrencyProvider.class)
    public void inputAmount(String currency, double buyRate) {
        convertorSteps.convertForeignToGel(currency, Constants.INPUT_VALUE);
    }

    @Test(description = "Verify Calculation", priority = 3,
            dataProvider = "currencyData", dataProviderClass = CurrencyProvider.class)
    public void verifyCalculation(String currency, double buyRate) {
        convertorSteps.convertForeignToGel(currency, Constants.INPUT_VALUE);

        String expected = convertorSteps.expectedGelValue(currency, Constants.INPUT_VALUE, buyRate);

        convertorSteps.getGelAmountField()
                .shouldHave(Condition.value(expected), Duration.ofSeconds(5));
    }

}


