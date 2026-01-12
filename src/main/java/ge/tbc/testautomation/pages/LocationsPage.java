package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.WithText;
import ge.tbc.testautomation.constants.Constants;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class LocationsPage {
    public SelenideElement citySelector = $(withText("აირჩიე ქალაქი")).parent();
    public SelenideElement cityInput =  $x("//input[@placeholder='Filter regions']");
    public SelenideElement locationInput = $x("//input[@class='search-input']");
    public SelenideElement locationType = $(withText(Constants.LOCATION_TYPE));
    public ElementsCollection filteredLocations = $$x("//div[@class='tbcx-pw-atm-branches-section__list-item-title tbcx-pw-title']");
}
