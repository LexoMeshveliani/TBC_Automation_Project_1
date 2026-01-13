package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.pages.AccountingPage;
import ge.tbc.testautomation.steps.AccountingPageSteps;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class ValidateYOYFinancialReportAccessibility extends BaseTest{
    AccountingPageSteps steps = new AccountingPageSteps();
    AccountingPage page = new AccountingPage();

    @Test(description = "navigate to Financial Reports page", priority = 1)
    public void locateAccaunting() {
        homePageSteps.acceptCookie();
        homePageSteps.redirectToAccounting();
    }

    @Test(description="Validate NBG (სებ) Reports for 2024 and 2023", priority = 2)
    void validateNbgReports() {
        steps.downloadNbgReport("2024");
        steps.downloadNbgReport("2023");
    }

    @Test(description="Validate Annual Accounting Reports for 2024 and 2023", priority = 3)
    void validateAnnualAccountingReports() {
        steps.downloadPdfReport(page.annualAccountingContainer, "2024");
        steps.downloadPdfReport(page.annualAccountingContainer, "2023");
    }

    @Test(description="Validate CSR and Sustainable Development Reports", priority = 4)
    void validateCSRReports() {
        steps.downloadPdfReport(page.csrContainer, "2024");
        steps.downloadPdfReport(page.csrContainer, "2023");
    }

    @Test(description="Validate CSR and Sustainable Development Reports")
    void validateSustainableDevelopmentReports() {
        steps.downloadPdfReport(page.sustainableContainer, "2024");
        steps.downloadPdfReport(page.sustainableContainer, "2023");

        sleep(5000);
    }
}