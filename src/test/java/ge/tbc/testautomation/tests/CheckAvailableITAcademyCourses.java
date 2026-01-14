package ge.tbc.testautomation.tests;

import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.constants.Constants;
import ge.tbc.testautomation.steps.CommonStep;
import ge.tbc.testautomation.steps.ITAcademySteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckAvailableITAcademyCourses extends BaseTest{


    @Test(description = "navigate to IT academy page", priority = 1)
    public void NavigateToEducation() {
        homePageSteps.acceptCookie();
        commonStep.openNavigation();
        homePageSteps.redirectToITAcademy();
    }

    @Test(description = "Check available courses", priority = 2)
    public void step2_checkAvailable() {
        steps.verifyCoursesVisible();
    }

    @Test(description = "Enter Course Page", priority = 3)
    public void step3_validateAllContainers() {
        steps.validateAllCourses();
    }

    @Test(description = "Return to IT academy page", priority = 4)
    public void step4_returnCheck() {
        steps.verifyCoursesVisible();
    }
}
