package Config;

import Config.AppiumServer;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class Hooks {
MobileDriverContext context;

    @BeforeTest
    public void BeforeTest() throws MalformedURLException {
        AppiumServer.Start();
        context=new MobileDriverContext();
        System.out.println("BEFORE STEP");
    }

    @AfterTest
    public void AfterTest(){
        context.CloseDriverContext();
        AppiumServer.Stop();
        System.out.println("AFTER STEP");

    }
}
