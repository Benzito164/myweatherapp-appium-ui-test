package PageObjectsImplementation.Ios;

import PageObjects.LocationPageObjects;
import PageObjectsImplementation.HelperMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LocationPage extends HelperMethods {

    LocationPageObjects locationPageObjects = new LocationPageObjects();

    public LocationPage(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), locationPageObjects);
    }


    public void addLocation(String location ){
        waitForElement(locationPageObjects.searchButton).click();
        waitForElement(locationPageObjects.uiSearchLocationTextfield).sendKeys(location);
        List<MobileElement> locationResults = locationPageObjects.uiLocationResultTable;
        for (MobileElement locations :locationResults){
            if (locations.getText().equals(location)){
                locations.click();
                return;
            }

        }

    }

    public void deleteLocation(String location){
        WebElement locationForecast = getWeatherInformation(location);
        TouchActions action = new TouchActions(driver);
        action.longPress(locationForecast);
        action.release(locationForecast);
        action.perform();
    }

    public void selectWeatherLocation(String location){
       waitForElement(getWeatherInformation(location)).click();

    }

    public String getHeaderViewLocationName(){
        return waitForElement(locationPageObjects.headerWeatherViewLocationName).getText();
    }

    public WebElement getWeatherInformation(String location){
        for (MobileElement locationWeather : locationPageObjects.weatherInformation){
            if (location.equals(locationWeather.getText())){
                return locationWeather;
            }
        }
        return null;
    }
}
