package cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Pages;

public class InventoryListPageSteps {
    @Then("^I am on inventory page$")
    public void iAmOnInventoryPage() {
        Pages.inventoryList.assertIsOnPage();
    }

    @Then("^I see \"(.*)\" items on inventory page$")
    public void iSeeItemsOnInventoryPage(int num) {
        Pages.inventoryList.assertInventoryItemsCountIs(num);
    }
}
