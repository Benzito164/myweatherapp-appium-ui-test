package PageObjectsImplementation.Ios;

import Config.MobileDriverContext;
import PageObjects.LocationPageObjects;
import PageObjectsImplementation.HelperMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class LocationPage extends HelperMethods {

    LocationPageObjects locationPageObjects = new LocationPageObjects();

    public LocationPage(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), locationPageObjects);
    }


    public void addLocation(String location ){
        waitForElement(locationPageObjects.searchButton).click();
        waitForElement(locationPageObjects.uiSearchLocationTextfield).sendKeys(location);
        waitForElement(locationPageObjects.uiSearchLocationTextfield).sendKeys(" ");
        for (MobileElement locations :locationPageObjects.uiLocationResultTable){
            if (locations.getAttribute("label").equals(location)){
                locations.click();
                break;
            }

        }
        waitForElement(locationPageObjects.addLocationButton).click();
    }

    public void deleteLocation(String location){
        WebElement locationForecast = getWeatherInformation(location);
        TouchAction action = new TouchAction(driver);
        action.longPress(LongPressOptions.longPressOptions()
                .withElement(element(locationForecast))
                .withDuration(Duration.ofSeconds(4))).release().perform();


    }

    public void selectWeatherLocation(String location){
       waitForElement(getWeatherInformation(location)).click();

    }

    public String getHeaderViewLocationName(){
        return waitForElement(locationPageObjects.headerWeatherViewLocationName).getText();
    }

    public MobileElement getWeatherInformation(String location){
        for (MobileElement locationWeather : locationPageObjects.weatherInformation){
            String weatherLocation = locationWeather.getAttribute("label");
            try {
                if ((location.contains(weatherLocation))){
                    return locationWeather;
                }
            } catch (Exception ex) {
                return null;
            }

        }
        return null;
    }

    public void resetApp(){
        try {
            waitForElement(locationPageObjects.restartIcon).click();
            waitForElement(locationPageObjects.resetButton).click();
        } catch (Exception error) {
            waitForElement(locationPageObjects.uiSearchCancelButton).click();
            waitForElement(locationPageObjects.restartIcon).click();
            waitForElement(locationPageObjects.resetButton).click();
        }
    }
}
