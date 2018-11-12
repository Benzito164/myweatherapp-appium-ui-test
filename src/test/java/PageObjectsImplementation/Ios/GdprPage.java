package PageObjectsImplementation.Ios;

import PageObjects.PrivacyPolicyPageObjects;
import PageObjectsImplementation.Android.PrivacyPolicyPage;
import PageObjectsImplementation.HelperMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GdprPage extends HelperMethods {

    PrivacyPolicyPageObjects privacyPolicyPageObjects = new PrivacyPolicyPageObjects();

    public GdprPage(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), privacyPolicyPageObjects);
    }

    public GdprPage acceptPrivacyPolicyWithPersonalisedAds(){

        return this;
    }

    public GdprPage acceptPrivacyPolicyWithNonPersonalisedAds(){

        return this;
    }

    public GdprPage setAnalyticsPreferences(Boolean[] values){

        return this;
    }

    public GdprPage viewAllPrivacyPolicy(){
        waitForElement(privacyPolicyPageObjects.agreeButton).click();
        return this;
    }

    public GdprPage viewLinkToPartners(){
        waitForElement(privacyPolicyPageObjects.agreeButton).click();
        return this;
    }

}
