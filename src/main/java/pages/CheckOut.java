package pages;

import extensions.Element;

import org.openqa.selenium.support.How;


import static org.junit.Assert.assertTrue;


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




    public CheckOut clickCheckOut() {
        click_checkout.click();
        return Pages.clickCheck;
    }


    public CheckOut checkHeader(String header){
        check_header.equals(header);
        return this;
    }


    public CheckOut fillFirstName(String s) {
        firstname.sendKeys(s);
        return this;

    }


    public CheckOut fillLastName(String s) {
        lastname.sendKeys(s);
        return this;
    }


    public CheckOut zipCode (String s) {
        zipcode.sendKeys(s);
        return this;
    }


    public CheckOut cancelClick () {
        cancel_click.click();
        return Pages.clickCheck;
    }



    public CheckOut continueClick () {
        continue_click.click();
        return Pages.clickCheck;
    }


    public CheckOut errorContinue(){
        assertTrue(error_continue.isDisplayed());
        return this;
    }


    public CheckOut headerCheckout(String headercheck){
       checkout_header.equals(headercheck);
        return this;
    }
}


