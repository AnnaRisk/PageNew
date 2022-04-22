package cucumber.steps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import pages.Pages;

public class CartSteps {

    @And("^I chose the product and check it$")
    public void iChoseTheProductAndCheckIt() {

        Pages.checkButton
                .clickButton1();
    }

    @Then("^I chose the product and click button Add to cart$")
    public void iChoseTheProductAndClickButtonAddToCart() {
        Pages.checkButton
                .clickAddButton();
    }
       @And("^I click to the Cart$")
    public void iClickToTheCart() {
        Pages.checkButton
                .clickCart();

    }
    @Then("^I check that the product in the cart$")
    public void iCheckThatTheProductInTheCart() {
        Pages.checkButton
                .checkOrder("Sauce Labs Fleece Jacket");

    }
    @And("^I  click to remove button$")
    public void iClickToRemoveButton() {
        Pages.checkButton
                .removeClick();
    }
    @Then("^I check that order is deleted$")
    public void iCheckThatOrderIsDeleted() {
        Pages.checkButton
        .checkOrder("");
    }


    }


