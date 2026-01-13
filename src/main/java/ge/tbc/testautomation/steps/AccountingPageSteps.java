package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.AccountingPage;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AccountingPageSteps {
    AccountingPage page = new AccountingPage();

    public void scrollToContainer(SelenideElement container) {
        // 1. Scroll the element to the top
        container.scrollTo();
        // 2. Move the window back up by 150px (height of the navigation bar)
        Selenide.executeJavaScript("window.scrollBy(0, -150);");
    }

    public void downloadNbgReport(String year) {
        SelenideElement container = page.nbgContainer;

        scrollToContainer(container);

        container.scrollTo().shouldBe(Condition.visible);

        page.getYearBtn(container, year).shouldBe(Condition.visible).click();

        page.getMoreBtn(container).shouldBe(Condition.visible).click();

        container.$(withText("Annual")).parent()
                .$(withText("Excel")).shouldBe(Condition.visible).click();
    }

    public void downloadPdfReport(SelenideElement container, String year) {
        container.should(Condition.exist, Duration.ofSeconds(10));

        container.scrollTo();

        executeJavaScript("arguments[0].scrollIntoView({block: 'center'});", container);

        page.getYearBtn(container, year).shouldBe(Condition.visible).click();
        container.$(withText("PDF")).shouldBe(Condition.visible).click();
    }
}