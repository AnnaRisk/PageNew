package cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.users.Context;
import models.users.UserCredentials;
import pages.Pages;

public class LoginPageSteps {

    // When tests.steps
    @When("^I try to log in$")
    public void iTryToLogIn() {
        UserCredentials creds = (UserCredentials) Context.get("userCredentials");
        Pages.login.loginUserSuccess(creds);
    }

    //Then tests.steps
    @Then("^I am on login page$")
    public void iAmOnLoginPage() {
        Pages.login.assertIsOnPage();
    }

    @Then("^I see error message$")
    public void iSeeErrorMessage() {
        Pages.login.assertErrorMessagePresent();
    }
}
