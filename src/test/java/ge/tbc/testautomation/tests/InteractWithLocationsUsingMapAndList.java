package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

public class InteractWithLocationsUsingMapAndList extends BaseTest{
    @Test(description = "Open locations page", priority = 1)
    public void openLocationsPage(){
        homePageSteps.openNavigation();
        homePageSteps.redirectToLocations();
    }

    @Test(priority = 2, description = "Select location from list")
    public void selectLocationFromList() {
        locationsPageSteps.selectFirstLocationFromList();
        locationsPageSteps.verifyCardIsActive();
        locationsPageSteps.verifyMarkerIsPresentOnMap();
    }

    @Test(priority = 3, description = "Zoom into the marker")
    public void zoomIntoMarker() {
        locationsPageSteps.doubleClickMarkedLocation();
    }

    @Test(priority = 4, description = "Choose nearby branch")
    public void chooseNearbyBranch() {
        locationsPageSteps.clickNeighborLocation();
    }

}
