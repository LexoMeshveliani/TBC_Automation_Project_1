package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.constants.Constants;
import ge.tbc.testautomation.pages.LocationsPage;
import org.openqa.selenium.support.ui.ExpectedCondition;

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
        locationsPage.filteredLocations.first().shouldHave(Condition.text(Constants.LOCATION_INPUT));
    }
}
