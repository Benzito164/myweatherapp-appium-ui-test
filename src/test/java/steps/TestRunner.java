package steps;


import Config.AppiumServer;
import Config.ConfigReader;
import Config.MobileDriverContext;
import Config.MobileDriverContext.AppState;
import PageObjectsImplementation.HelperMethods;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.*;
import java.io.File;


@CucumberOptions(
        features = "src/test/java/features/",
        strict = true,
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/output/report.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

    MobileDriverContext context;
    
    @BeforeSuite
    public void BeforeTest() throws Exception {
        AppiumServer.Start();
        context=new MobileDriverContext();
        System.out.println("BEFORE STEP");
    }


    @Before
    public void Before(){
    }







    @After
    public void afterMethod(Scenario scenario) throws  Exception{
        if(scenario.isFailed()){
            String imageName = scenario.getName();
            HelperMethods.takeScreenShot(imageName);
            Reporter.addScreenCaptureFromPath(imageName+".png");
        }
        context.performAppActivity(AppState.Restart);
        System.out.println("AFTER");

    }

    @AfterSuite
    public void AfterTest(){
        context.CloseDriverContext();
        AppiumServer.Stop();
        System.out.println("AFTER SUITE");

    }
    @AfterClass
    public static void TearDown() throws  Exception{
        ConfigReader reader = new ConfigReader();
        Reporter.loadXMLConfig(new File(reader.getExtentConfig()));
        System.out.println("AFTER CLASS");
    }
}