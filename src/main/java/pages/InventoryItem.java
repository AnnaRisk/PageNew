package pages;

import extensions.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class InventoryItem extends BasePage{



    private Element inventoryList = new Element(How.XPATH, "//div[contains(@class, 'inventory_list')]");



    private List<WebElement> getInventoryItems() {
        return inventoryList.get().findElements(By.xpath("./div[contains(@class, 'inventory_item')]"));
    }

    public InventoryItem() {
        URL += "/inventory.html";
    }


    public InventoryItem assertInventoryItemsCountIs(int num) {
        assertEquals(String.format("Должно быть %s товаров", num),
                num, getInventoryItems().size());
        return this;
    }

    public void assertIsOnPage() {
        assertTrue(inventoryList.isDisplayed());
    }
}
