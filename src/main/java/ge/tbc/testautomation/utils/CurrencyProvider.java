package ge.tbc.testautomation.utils;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.ConvertorPage;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class CurrencyProvider {
    ConvertorPage convertorPage = new ConvertorPage();



    @DataProvider(name = "currencyData")
    public Object[][] currencyData() {
        convertorPage.table.shouldBe(Condition.visible, Duration.ofSeconds(10));

        int size = convertorPage.initializeCurrencies().size();
        Object[][] data = new Object[size][2];

        for (int i = 0; i < size; i++) {
            String currency = convertorPage.initializeCurrencies().get(i).getText().trim();

            String valueText = convertorPage.initializeValues().get(i).getText().trim();
            double value = Double.parseDouble(valueText);

            data[i][0] = currency;
            data[i][1] = value;
        }

        return data;
    }
}
