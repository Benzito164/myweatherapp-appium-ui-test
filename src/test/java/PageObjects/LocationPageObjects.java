package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.SelendroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;

public class LocationPageObjects {


    public LocationPageObjects(){

    }

    @CacheLookup
    @AndroidFindBy(id = "gdpr_intro_text")
    @iOSFindBy(accessibility = "locationSearchButton")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement searchButton;

    @CacheLookup
    @AndroidFindBy(id = "gdpr_intro_text")
    @iOSFindBy(accessibility = "restartButton")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement restartIcon;

    @CacheLookup
    @AndroidFindBy(id = "gdpr_intro_text")
    @iOSFindBy(accessibility = "Reset")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement resetButton;

    @CacheLookup
    @AndroidFindBy(id = "gdpr_intro_text")
    @iOSFindBy(accessibility = ".//*[@value='Site Address (URL)']")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement locationNameHeaderDisplay;

    @CacheLookup
    @AndroidFindBy(id = "gdpr_intro_text")
    @iOSFindBy(accessibility = "Cancel")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement uiSearchCancelButton;

    @CacheLookup
    @AndroidFindBy(id = "gdpr_intro_text")
    @iOSFindBy(accessibility = "Location")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement uiSearchLocationTextfield;

    @CacheLookup
    @AndroidFindBy(id = "gdpr_intro_text")
    @iOSFindBy(xpath = ".//*[@name='textLabelIndentifier']")
    @SelendroidFindBy(id = "nux_url")
    public List<MobileElement> uiLocationResultTable;

    @CacheLookup
    @AndroidFindBy(id = "gdpr_intro_text")
    @iOSFindBy(xpath = ".//*[@name='locationLabelIdentifier']")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement headerWeatherViewLocationName;

    @CacheLookup
    @AndroidFindBy(id = "gdpr_intro_text")
    @iOSFindBy(accessibility = ".//*[@value='Site Address (URL)']")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement uiPopUp;

    @CacheLookup
    @iOSFindBy(accessibility = "weatherCellid")
    public List<MobileElement> weatherInformation;


}
