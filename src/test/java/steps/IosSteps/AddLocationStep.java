package steps.IosSteps;

import Config.MobileDriverContext;
import PageObjectsImplementation.Ios.LocationPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class AddLocationStep {
     LocationPage locationPage = new LocationPage(MobileDriverContext.driver);
    @Given("^I launch the app$")
    public void iLaunchTheApp() {
    }

    @When("^I add \"([^\"]*)\" as a location$")
    public void iAddAsALocation(String arg0) throws Throwable {
        locationPage.addLocation(arg0);
    }

    @Then("^I should see a \"([^\"]*)\" forecast on my Homescreen$")
    public void iShouldSeeAForecastOnMyHomescreen(String arg0) throws Throwable {
        Assert.assertTrue(locationPage.getWeatherInformation(arg0) != null);
    }

    @When("^I long press on \"([^\"]*)\" forecast$")
    public void iLongPressOnForecast(String arg0) throws Throwable {
        locationPage.deleteLocation(arg0);
    }

    @Then("^I should not see any more forecast for \"([^\"]*)\"$")
    public void iShouldNotSeeAnyMoreForecastFor(String arg0) throws Throwable {
       Assert.assertTrue(locationPage.getWeatherInformation(arg0) == null);
    }

    @Then("^I should see a pop up telling me the location is already added$")
    public void iShouldSeeAPopUpTellingMeTheLocationIsAlreadyAdded() {

    }

    @When("^I tap on the forecast information for \"([^\"]*)\"$")
    public void iTapOnTheForecastInformationFor(String arg0) throws Throwable {
      locationPage.selectWeatherLocation(arg0);
    }

    @Then("^The weather information for \"([^\"]*)\" should be displayed above$")
    public void theWeatherInformationForShouldBeDisplayedAbove(String arg0) throws Throwable {
       Assert.assertTrue(locationPage.getHeaderViewLocationName().contains(arg0));
    }
}
