package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.pages.AccountingPage;
import ge.tbc.testautomation.steps.AccountingPageSteps;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class ValidateYOYFinancialReportAccessibility extends BaseTest{


    @Test(description = "navigate to Financial Reports page", priority = 1)
    public void locateAccaunting() {
        commonStep.openNavigation();
        homePageSteps.redirectToAccounting();
    }

    @Test(description="Validate NBG (სებ) Reports for 2024 and 2023", priority = 2)
    void validateNbgReports() {
        accountingPageSteps.downloadNbgReport("2024");
        accountingPageSteps.downloadNbgReport("2023");
    }

    @Test(description="Validate Annual Accounting Reports for 2024 and 2023", priority = 3)
    void validateAnnualAccountingReports() {
        accountingPageSteps.downloadPdfReport(page.annualAccountingContainer, "2024");
        accountingPageSteps.downloadPdfReport(page.annualAccountingContainer, "2023");
    }

    @Test(description="Validate CSR and Sustainable Development Reports", priority = 4)
    void validateCSRReports() {
        accountingPageSteps.downloadPdfReport(page.csrContainer, "2024");
        accountingPageSteps.downloadPdfReport(page.csrContainer, "2023");
    }

    @Test(description="Validate CSR and Sustainable Development Reports", priority = 5)
    void validateSustainableDevelopmentReports() {
        accountingPageSteps.downloadPdfReport(page.sustainableContainer, "2024");
        accountingPageSteps.downloadPdfReport(page.sustainableContainer, "2023");

    }
}