package steps.AndroidSteps;


import Config.Hooks;
import Config.MobileDriverContext;
import PageObjectsImplementation.Android.PrivacyPolicyPage;
import PageObjectsImplementation.HelperMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PrivacyStep extends HelperMethods {

    PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage(MobileDriverContext.driver);

    @Given("^I open the app$")
    public void i_launch_the_app()  {
        System.out.println("App launched");
    }

    @And("^I see the GDPR privacy policy screen$")
    public void i_accept_then()  {
        privacyPolicyPage.waitforGdprScreen();

    }

    @When("^I click the back button$")
    public void iOpenIt() throws Throwable {
      navigateBack();
    }

    @When("^I agree to metoffice privacy policy$")
    public void i_Open_It() throws Throwable {

    }


    @Then("^I see GDPR personalised advertising screen$")
    public void i_should_see_the_gdpr_screen()  {
        privacyPolicyPage.waitforGdprPersonalisedAdsScreen();

    }




}
