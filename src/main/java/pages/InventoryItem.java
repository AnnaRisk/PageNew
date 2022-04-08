package pages;

import extensions.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.How;

import java.util.List;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryItem extends BasePage{



    private Element inventoryList = new Element(How.XPATH, "//div[contains(@class, 'inventory_list')]");


    @Step("Try to find all inventory items")
    private List<WebElement> getInventoryItems() {
        return inventoryList.get().findElements(By.xpath("./div[contains(@class, 'inventory_item')]"));
    }

    public InventoryItem() {
        URL += "/inventory.html";
    }

    @Step("Assert that we can see {num} goods on the page")
    public InventoryItem assertInventoryItemsCountIs(int num) {
        assertEquals(num, getInventoryItems().size(),
                String.format("Должно быть %s товаров", num));
        return this;1
    }


}
