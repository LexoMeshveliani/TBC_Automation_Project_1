package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.constants.Constants;
import ge.tbc.testautomation.steps.LocationsPageSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterLocationsByCityAndTypeTest extends BaseTest{


    @Test(description = "Open locations page", priority = 1)
    public void openLocationsPage(){
        commonStep.openNavigation();
        homePageSteps.redirectToLocations();
    }

    @Test(description = "Apply city filter", priority = 2)
    public void applyCityFilters(){
        locationsPageSteps.checkCityFilter(Constants.CITY_NAME);
    }

    @Test(description = "Search for specific location", priority = 3)
    public void SearchForSpecificLocation(){
        locationsPageSteps.locationInput(Constants.LOCATION_INPUT);
    }

    @Test(description = "Apply location type filter", priority = 4)
    public void ApplyLocationTypeFilter(){
        locationsPageSteps.locationType();
    }

    @Test(description = "Verify filtered results", priority = 5)
    public void VerifyFilteredResults(){
        locationsPageSteps.filterCheck();
    }
}
