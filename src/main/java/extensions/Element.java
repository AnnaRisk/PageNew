package extensions;


import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Element {

    private By by;

    public Element(How type, String locator) {
        switch (type) {
            case ID: this.by = By.id(locator); break;
            case NAME: this.by = By.name(locator); break;
            case XPATH: this.by = By.xpath(locator); break;
            case LINK_TEXT: this.by = By.linkText(locator); break;
            default: this.by = By.cssSelector(locator); break;
        }
    }

    public void sendKeys(String s) {
        Allure.step("Send \"" + s + "\" to element: " + by.toString());
        get().sendKeys(s);
    }

    public void click() {
        Allure.step("Click element: " + by.toString());
        get().click();
    }

    public boolean isDisplayed() {
        Allure.step("Get displayed property of element: " + by.toString());
        return get().isDisplayed();
    }

    public WebElement get() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        return wait.until(visibilityOfElementLocated(by));
    }
}
