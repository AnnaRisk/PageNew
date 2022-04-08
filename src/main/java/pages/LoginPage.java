package pages;

import extensions.Element;
import users.UsersCred;
import extensions.Driver;
import io.qameta.allure.Step;

import org.openqa.selenium.support.How;

import static org.junit.jupiter.api.Assertions.assertTrue;



public class LoginPage extends BasePage {


   public Element userNameInput = new Element(How.XPATH, "//*[@class=\\\"input_error form_input\\\"]");
    public  Element userPasswordInput = new Element(How.CSS, "#password");
    private Element loginButton = new Element(How.XPATH, "//input[@id='login-button']");
    private Element errorMessage = new Element(How.XPATH, "//h3[@data-test='error']");


    public LoginPage() {
        URL += "/";
    }


    @Step("Open login page")
    public  LoginPage open (){
       Driver.get().navigate().to(URL);

        return this;
    }

    @Step ("Fill username input with value {s}")
    public LoginPage fillUserInput(String s) {
        userNameInput.sendKeys(s);
        return this;
    }
    @Step ("Fill username input with value {0}")
    public LoginPage fillPasswordInput(String s) {
        userPasswordInput.sendKeys(s);
        return this;
    }

    @Step ("Click login button")
    public InventoryItem clickLoginButton() {
        loginButton.click();
        return pages.inventoryList;
    }

    @Step ("Successfully logged in with user: {creds.username} {creds.password}")
    public InventoryItem loginUserSuccess(UsersCred creds) {

        return fillUserInput(creds.getUsername())
                .fillPasswordInput(creds.getPassword())
                .clickLoginButton();

    }
    @Step("Try to log in with user: {creds.username} {creds.password}")
    public LoginPage loginUserFailed(UsersCred creds) {
        fillUserInput(creds.getUsername())
                .fillPasswordInput(creds.getPassword())
                .clickLoginButton();
        return this;
    }

    @Step("Assert that alert message is visible")
    public LoginPage assertErrorMessagePresent(){
        assertTrue(errorMessage.isDisplayed());
        return this;
    }


}
