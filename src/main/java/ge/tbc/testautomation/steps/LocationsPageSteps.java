package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.constants.Constants;
import ge.tbc.testautomation.pages.LocationsPage;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static com.codeborne.selenide.Condition.*;

public class LocationsPageSteps {
    LocationsPage locationsPage = new LocationsPage();

    public void checkCityFilter(String value){
        locationsPage.citySelector.click();
        locationsPage.cityInput.setValue(value).pressEnter();
    }

    public void locationInput(String value){
        locationsPage.locationInput.setValue(value);
    }

    public void locationType(){
        locationsPage.locationType.click();
    }

    public void filterCheck(){
        locationsPage.filteredLocations.first().shouldHave(text(Constants.LOCATION_INPUT));
    }

    public void selectFirstLocationFromList() {
        locationsPage.locationCards.first().hover().shouldBe(visible).click();
    }

    public void verifyCardIsActive() {
        locationsPage.locationCards.first().shouldHave(cssClass("active"));
    }

    public void verifyMarkerIsPresentOnMap() {
        locationsPage.markedLocation.shouldBe(visible);
    }

    public void doubleClickMarkedLocation() {
        locationsPage.markedLocation.hover().doubleClick();
    }

    public void clickNeighborLocation() {
        locationsPage.neighborLocation.hover().shouldBe(visible).click();
    }

    public void verifyNewActiveMatch(String expectedTextPart) {
        locationsPage.matchInList.hover().shouldBe(visible).shouldHave(text(expectedTextPart));
    }
}
