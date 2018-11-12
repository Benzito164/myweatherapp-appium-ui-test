package Tests;

import Config.Hooks;
import Config.MobileDriverContext;
import PageObjectsImplementation.Android.PrivacyPolicyPage;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppTest extends Hooks {


    PrivacyPolicyPage privacyPolicyPage;

    public void LaunchApp() throws MalformedURLException {

    }


    public void aunchApp() throws MalformedURLException, InterruptedException {
      System.out.println("Test 1");
      Thread.sleep(9000);
    }


    public void unchApp() throws MalformedURLException {
        System.out.println("Test 2");
    }


}
