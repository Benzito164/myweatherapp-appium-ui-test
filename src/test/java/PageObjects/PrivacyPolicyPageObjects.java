package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.SelendroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.CacheLookup;

public class PrivacyPolicyPageObjects {

    public PrivacyPolicyPageObjects(){

    }



    @CacheLookup
    @AndroidFindBy(id = "gdpr_intro_text")
    @iOSFindBy(xpath = ".//*[@value='Site Address (URL)']")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement privacyPolicyScreen;

    @CacheLookup
    @AndroidFindBy(id = "agree")
    @iOSFindBy(xpath = ".//*[@value='Site Address (URL)']")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement agreeButton;

    @CacheLookup
    @AndroidFindBy(id = "gdpr_personalised_ads_heading")
    @iOSFindBy(xpath = ".//*[@value='Site Address (URL)']")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement personalisedAdsScreen;

    @CacheLookup
    @AndroidFindBy(id = "manage")
    @iOSFindBy(xpath = ".//*[@value='Site Address (URL)']")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement manageMydataButton;

    @CacheLookup
    @AndroidFindBy(id = "gdpr_manage_header")
    @iOSFindBy(xpath = ".//*[@value='Site Address (URL)']")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement gdprManageScreen;


    @CacheLookup
    @AndroidFindBy(id = "agree_personalised")
    @iOSFindBy(xpath = ".//*[@value='Site Address (URL)']")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement agreePersonlisedAds;


    @CacheLookup
    @AndroidFindBy(id = "agree_personalised")
    @iOSFindBy(xpath = ".//*[@value='Site Address (URL)']")
    @SelendroidFindBy(id = "nux_url")
    public MobileElement gdprToggle;


}
