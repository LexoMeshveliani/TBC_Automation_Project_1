package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.AccountingPage;
import ge.tbc.testautomation.utils.TestContext;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AccountingPageSteps {
    AccountingPage page = new AccountingPage();

    public void scrollToContainer(SelenideElement container) {
        container.scrollTo();
        Selenide.executeJavaScript("window.scrollBy(0, -150);");
    }

    private void disableBlockingHeaderOnMobileIfPresent() {
        if (!TestContext.isMobile()) return;

        executeJavaScript("""
            const el = document.querySelector('div.header-wrapper');
            if (el) {
              el.style.pointerEvents = 'none';
              el.style.visibility = 'hidden';
            }
        """);
    }

    public void downloadNbgReport(String year) {
        SelenideElement container = page.nbgContainer;

        scrollToContainer(container);
        container.scrollTo().shouldBe(Condition.visible);

        disableBlockingHeaderOnMobileIfPresent();

        page.getYearBtn(container, year).shouldBe(Condition.visible).click();

        disableBlockingHeaderOnMobileIfPresent();

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