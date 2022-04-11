package pages;

import extensions.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.support.How;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckOut extends BasePage {

    private Element click_checkout = new Element(How.XPATH, "//*[@class=\"btn btn_action btn_medium checkout_button\"] ");
    public Element firstname = new Element(How.XPATH, "//input[contains(@placeholder,'First Name')]");
    public Element  check_header = new Element(How.CSS, "//span[text()='Checkout: Your Information']");
    private Element lastname = new Element(How.XPATH, "//input[contains(@placeholder,'Last Name')]");
    private Element zipcode = new Element(How.XPATH, "//input[contains(@placeholder,'Zip/Postal Code')]");
    private Element cancel_click = new Element(How.XPATH, "//*[@class=\"btn btn_secondary back btn_medium cart_cancel_link\"]");
    private Element continue_click = new Element(How.XPATH, "//*[@class=\"submit-button btn btn_primary cart_button btn_action\"]");
    private Element error_continue = new Element(How.XPATH, "//*[@class=\"error-message-container error\"]");
    private Element checkout_header = new Element(How.XPATH, "//*[@class=\"error-message-container error\"]");


    @Step("CheckOut click")

    public CheckOut clickCheckOut() {
        click_checkout.click();
        return Pages.clickCheck;
    }

    @Step ("Check header")
    public CheckOut checkHeader(String header){
        check_header.equals(header);
        return this;
    }

    @Step("Fill firstname input with value {s}")
    public CheckOut fillFirstName(String s) {
        firstname.sendKeys(s);
        return this;

    }

    @Step("Fill lastname input with value {s}")
    public CheckOut fillLastName(String s) {
        lastname.sendKeys(s);
        return this;
    }

    @Step("Fill zipcode input with value {s}")
    public CheckOut zipCode (String s) {
        zipcode.sendKeys(s);
        return this;
    }

    @Step("Click cancel")
    public CheckOut cancelClick () {
        cancel_click.click();
        return Pages.clickCheck;
    }


    @Step("Click continue")
    public CheckOut continueClick () {
        continue_click.click();
        return Pages.clickCheck;
    }

    @Step("Assert error message")
    public CheckOut errorContinue(){
        assertTrue(error_continue.isDisplayed());
        return this;
    }

    @Step ("Check header checkout")
    public CheckOut headerCheckout(String headercheck){
       checkout_header.equals(headercheck);
        return this;
    }
}


