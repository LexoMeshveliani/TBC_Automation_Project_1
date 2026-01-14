package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CoursePage {
    public SelenideElement courseInfo = $x("//ng-component[contains(text(),'კურსის აღწერა')]");
    public SelenideElement backButton = $x("//a[contains(text(), 'IT აკადემია')]");
}
