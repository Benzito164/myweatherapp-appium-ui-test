package PageObjectsImplementation.Android;

import PageObjects.PrivacyPolicyPageObjects;
import PageObjectsImplementation.HelperMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PrivacyPolicyPage extends HelperMethods {

    PrivacyPolicyPageObjects privacyPolicyPageObjects = new PrivacyPolicyPageObjects();

    public PrivacyPolicyPage(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), privacyPolicyPageObjects);
    }

    public PrivacyPolicyPage acceptPrivacyPolicyWithPersonalisedAds(){
        waitForElement(privacyPolicyPageObjects.agreeButton).click();
        return this;
    }

    public PrivacyPolicyPage waitforGdprScreen(){
        waitForElementToAppear(privacyPolicyPageObjects.agreeButton);
        return this;
    }

    public PrivacyPolicyPage waitforGdprPersonalisedAdsScreen(){
        waitForElementToAppear(privacyPolicyPageObjects.agreePersonlisedAds);
        return this;
    }

    public PrivacyPolicyPage clickManageButton(){
        waitForElement(privacyPolicyPageObjects.manageMydataButton).click();
        return this;
    }

    public PrivacyPolicyPage agreeToPersonalisedAds(){
        waitForElement(privacyPolicyPageObjects.agreePersonlisedAds).click();
        return this;
    }

}
