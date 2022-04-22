package cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.Pages;

public class CheckOutSteps {
   @Then("^I click to the ChekOut button$")
    public void iClickToTheChekOutButton() {

       Pages.clickCheck
               .clickCheckOut();

    }

    @And("^I check header on the CheckOut Page$")
    public void iCheckHeaderOnTheCheckOutPage() {

        Pages.clickCheck
                .checkHeader("CHECKOUT: YOUR INFORMATION");
    }



    @Given("^I fill Information Check$")
    public void iFillInformationCheck() {

        Pages.clickCheck
                .fillFirstName("Anna")
                .fillLastName("Rain")
                .zipCode("112233");
    }

    @And("^I click cancel and check InvenoryPage$")
    public void iClickCancelAndCheckInvenoryPage() {

        Pages.clickCheck
                .cancelClick();
        Pages.checkButton
                .checkOrder("Sauce Labs Fleece Jacket");

    }

    @And("^I dont fill information and click Continue button$")
    public void iDontFillInformationAndClickContinueButton() {

        Pages.clickCheck
                .continueClick()
                .errorContinue();
    }

    @And("^I click Continue button and check Success checkout$")
    public void iClickContinueButtonAndCheckSuccessCheckout() {

        Pages.clickCheck
                .continueClick()
                .headerCheckout("Sauce Labs Fleece Jacket");
    }
}
