package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ITAcademyPage {
    public ElementsCollection courseContainers = $$x("//div[@class='pane-container']/div");

    public SelenideElement getStatusLabel(SelenideElement container) {
        return container.$x(".//span");
    }
}
