package ge.tbc.testautomation.tests;

import org.testng.annotations.Test;

public class InteractWithLocationsUsingMapAndList extends BaseTest{
    @Test(description = "Open locations page", priority = 1)
    public void openLocationsPage(){
        homePageSteps.openNavigation();
        homePageSteps.redirectToLocations();
    }


}
