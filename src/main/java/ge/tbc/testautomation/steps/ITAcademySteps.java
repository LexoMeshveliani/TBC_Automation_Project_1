package ge.tbc.testautomation.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.constants.Constants;
import ge.tbc.testautomation.pages.CoursePage;
import ge.tbc.testautomation.pages.ITAcademyPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ITAcademySteps {
    ITAcademyPage itPage = new ITAcademyPage();
    CoursePage coursePage = new CoursePage();

    public void verifyCoursesVisible() {
        itPage.courseContainers.shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    public void validateAllCourses() {
        int count = itPage.courseContainers.size();

        for (int i = 0; i < count; i++) {
            SelenideElement container = itPage.courseContainers.get(i);

            container.hover();
            String status = itPage.getStatusLabel(container).getText().trim();

            container.click();

            coursePage.backButton.shouldBe(Condition.visible, Duration.ofSeconds(10));

            coursePage.courseInfo.shouldBe(Condition.visible).hover();
            executeJavaScript("window.scrollTo(0, document.body.scrollHeight / 2);");

            coursePage.backButton.hover().click();
            itPage.courseContainers.shouldHave(CollectionCondition.sizeGreaterThan(0));
        }
    }
}
