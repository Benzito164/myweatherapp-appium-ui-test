package Config;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriverContext {

    public static AppiumDriver<MobileElement> driver;
    private ConfigReader reader = new ConfigReader();

    public MobileDriverContext() throws MalformedURLException {
        if (reader.getDeviceToBeRun().equals("ios")){
            IosContext();
        }
        else {
            AndroidContext();
        }

    }


    public static  void performAppActivity(AppState state)  {
     switch (state){
         case Launch:
             driver.launchApp();
         case Close:
              driver.closeApp();
         case Install:
         case Restart:
              driver.resetApp();
         case Uninstall:

     }
    }

    public enum AppState {
        Close,
        Launch,
        Restart,
        Uninstall,
        Install,
        RunInBackground
    }

    public void CloseDriverContext(){
        driver.quit();
    }


    private void IosContext() throws MalformedURLException {
        setContext("ios","iPhone 7 Plus");
    }

    private void AndroidContext() throws MalformedURLException {
     setContext("android",reader.getAndroidDeviceName());
    }

    private void setContext(String platform,String name) throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, name);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        if (platform != "ios"){
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            cap.setCapability(MobileCapabilityType.APP, reader.getApkPath());
            driver = new AndroidDriver<MobileElement>(new URL(AppiumServer.url.toString()), cap);
        }
        else {
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            cap.setCapability(MobileCapabilityType.UDID, reader.getUdid());
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            cap.setCapability(MobileCapabilityType.APP, reader.getIpaPath());
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        }
    }
}
